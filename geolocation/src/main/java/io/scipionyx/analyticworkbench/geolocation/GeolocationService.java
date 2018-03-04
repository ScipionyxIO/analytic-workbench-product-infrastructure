package io.scipionyx.analyticworkbench.geolocation;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.zip.GZIPInputStream;

import javax.annotation.PostConstruct;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import com.maxmind.db.CHMCache;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.AsnResponse;
import com.maxmind.geoip2.model.CityResponse;

import lombok.Getter;
import lombok.Setter;

@Component
@EnableConfigurationProperties(GeolocationMetadata.class)
public class GeolocationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(GeolocationService.class);

	private DatabaseReader cityReader;

	private DatabaseReader asnReader;

	@Autowired
	private GeolocationMetadata metadata;

	@PostConstruct
	public void init() throws IOException {
		LOGGER.debug("Init Geolocation Service: configuration:{}", metadata.toString());
		loadDatabases();
	}

	private File fetchDatabaseFile(String url) throws IOException {

		File tmpFile = Files.createTempFile("MaxMindDatabase", ".mmdb.tar.gz").toFile();
		File dest = Files.createTempFile("MaxDatabase", ".mmdb").toFile();
		dest.delete();
		FileUtils.copyURLToFile(new URL(url), tmpFile);
		if (metadata.isUnTarGz()) {
			Path tmpDirectory = Files.createTempDirectory("MaxMindDatabase");
			untar(tmpFile, tmpDirectory.toFile(), true);
			List<File> asList = Arrays.asList(tmpDirectory.toFile().listFiles()[0].listFiles());
			for (File file : asList) {
				if (file.getName().startsWith("Geo")) {
					FileUtils.copyFileToDirectory(file, dest);
				}
			}

			FileUtils.forceDelete(tmpFile);
			FileUtils.deleteDirectory(tmpDirectory.toFile());
		}
		return dest;
	}

	public void copyURLToFile(final URL source, final File destination) throws IOException {
		final int connectionTimeout = 5000;
		final int readTimeout = 5000;
		final URLConnection connection = getConnection(source);
		connection.setConnectTimeout(connectionTimeout);
		connection.setReadTimeout(readTimeout);
		// FileUtils.copyInputStreamToFile(connection.getInputStream(), destination);
	}

	private URLConnection getConnection(final URL source) throws IOException {
		if (metadata.isUseProxy()) {
			return source.openConnection(
					new Proxy(Type.HTTP, new InetSocketAddress(metadata.getProxyHost(), metadata.getProxyPort())));
		} else {
			return source.openConnection();
		}
	}

	private void loadDatabases() throws IOException {
		File fetchDatabaseFile = fetchDatabaseFile(metadata.getCityDatabaseUrl());
		cityReader = new DatabaseReader.Builder(fetchDatabaseFile).withCache(new CHMCache()).build();
		FileUtils.forceDelete(fetchDatabaseFile);

		File fetchDatabaseFile2 = fetchDatabaseFile(metadata.getAsnDatabaseUrl());
		asnReader = new DatabaseReader.Builder(fetchDatabaseFile2).withCache(new CHMCache()).build();
		FileUtils.forceDelete(fetchDatabaseFile2);
	}

	public void untar(File inFile, File outputDir, boolean zipped) throws IOException {
		//
		FileUtils.cleanDirectory(outputDir);

		//
		InputStream inputStream = null;
		if (zipped) {
			inputStream = new BufferedInputStream(new GZIPInputStream(new FileInputStream(inFile)));
		} else {
			inputStream = new BufferedInputStream(new FileInputStream(inFile));
		}

		//
		TarArchiveInputStream tarArchiveInputStream = new TarArchiveInputStream(inputStream);
		TarArchiveEntry entry;
		while ((entry = tarArchiveInputStream.getNextTarEntry()) != null) {
			final File file = new File(outputDir, entry.getName());
			if (entry.isDirectory()) {
				file.mkdirs();
			} else if (entry.isFile()) {
				int count;
				byte data[] = new byte[2048];
				BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));
				while ((count = tarArchiveInputStream.read(data)) != -1) {
					outputStream.write(data, 0, count);
				}
				outputStream.flush();
				outputStream.close();
			}
		}
		tarArchiveInputStream.close();
	}

	public Response locate(String ip) throws IOException, GeoIp2Exception {
		InetAddress ipAddress = InetAddress.getByName(ip);
		CityResponse city = cityReader.city(ipAddress);
		AsnResponse asn = asnReader.asn(ipAddress);
		return new Response(city, asn);
	}

	@SuppressWarnings("serial")
	@Getter
	@Setter
	public class Response implements Serializable {

		private CityResponse city;

		private AsnResponse asn;

		public Response(CityResponse city, AsnResponse asn) {
			super();
			this.city = city;
			this.asn = asn;
		}

	}

}
