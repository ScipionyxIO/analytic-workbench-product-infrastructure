package io.scipionyx.analyticworkbench.infra;

import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(createIndex = true, indexName = "scipionyx_core_entity", refreshInterval = "-1s", type = "tenant")
public class Tenant extends Entity {

	private static final long serialVersionUID = 1L;

	private String code;

	private String name;

	private String description;

	private boolean active;

}
