package io.scipionyx.analyticworkbench.infra;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
public class ConfigurableField implements Serializable {

	private String name;

	private String description;

	// private layout

}
