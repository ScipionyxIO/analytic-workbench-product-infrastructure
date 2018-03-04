package io.scipionyx.analyticworkbench.backend.infra;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public abstract class AbstractService<ENTITY, REPOSITORY extends CrudRepository<ENTITY, String>> {

	private @Autowired(required = false) REPOSITORY repository;

	public ENTITY save(ENTITY entity) {
		return getRepository().save(entity);
	}

	public static Object fromString(String s) throws IOException, ClassNotFoundException {
		byte[] data = Base64.getDecoder().decode(s);
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
		Object o = ois.readObject();
		ois.close();
		return o;
	}

	public static String toString(Object o) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(o);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Base64.getEncoder().encodeToString(baos.toByteArray());
	}

	public static String toString(byte[] o) {
		return Base64.getEncoder().encodeToString(o);
	}

	public static byte[] decode(String s) {
		return Base64.getDecoder().decode(s);
	}

	public REPOSITORY getRepository() {
		return repository;
	}

}
