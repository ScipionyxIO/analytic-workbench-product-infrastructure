package io.scipionyx.analyticworkbench.infra;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@SuppressWarnings("serial")
public abstract class ConfigurableEntity extends Entity {

	private List<ConfigurableField> fields;

}
