package io.scipionyx.analyticworkbench.infra.elastic;

import java.io.IOException;

import org.springframework.data.elasticsearch.core.EntityMapper;

import io.scipionyx.analyticworkbench.infra.json.ScipionyxObjectMapper;

/**
 * 
 * 
 * 
 * @author Renato Mendes
 *
 */
public class ScipionyxEntityMapper implements EntityMapper {

	private ScipionyxObjectMapper objectMapper;

	public ScipionyxEntityMapper(ScipionyxObjectMapper objectMapper) {
		super();
		this.objectMapper = objectMapper;
	}

	@Override
	public String mapToString(Object object) throws IOException {
		return objectMapper.writeValueAsString(object);
	}

	@Override
	public <T> T mapToObject(String source, Class<T> clazz) throws IOException {
		return objectMapper.readValue(source, clazz);
	}

}
