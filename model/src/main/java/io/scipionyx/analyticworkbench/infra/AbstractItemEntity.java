package io.scipionyx.analyticworkbench.infra;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("serial")
public abstract class AbstractItemEntity extends Entity implements IEntity {

	private String name;

	private String description;

	private LocalDateTime created;

	private LocalDateTime modified;

	private boolean active;

}
