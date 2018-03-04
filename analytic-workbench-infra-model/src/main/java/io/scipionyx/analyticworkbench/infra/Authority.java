package io.scipionyx.analyticworkbench.infra;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(createIndex = true, indexName = "scipionyx_core_entity", refreshInterval = "-1s", type = "authority")
public class Authority extends Entity implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	private final String authority;

	@JsonCreator
	public Authority(@JsonProperty("authority") String authority) {
		this.authority = authority;
	}

	public Authority(String id, String authority) {
		this.authority = authority;
		this.setId(id);
	}

}
