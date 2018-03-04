package io.scipionyx.analyticworkbench.geolocation;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties(prefix = "io.scipionyx.infra.geolocation")
@Validated
public class GeolocationMetadata {

	private String reloadFrequency;

	private boolean unTarGz = true;

	private boolean useProxy = false;

	private String proxyHost;

	private int proxyPort;

	@NotNull
	private String cityDatabaseUrl = "http://geolite.maxmind.com/download/geoip/database/GeoLite2-City.tar.gz";

	@NotNull
	private String asnDatabaseUrl = "http://geolite.maxmind.com/download/geoip/database/GeoLite2-ASN.tar.gz";

}
