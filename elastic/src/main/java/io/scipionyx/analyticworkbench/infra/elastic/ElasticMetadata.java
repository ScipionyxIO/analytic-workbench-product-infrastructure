package io.scipionyx.analyticworkbench.infra.elastic;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties(prefix = "io.scipionyx.infra.elastic")
@Validated
public class ElasticMetadata {

	private String clusterName = "elasticsearch";

	private String nodes = "elasticsearch:9300";

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
