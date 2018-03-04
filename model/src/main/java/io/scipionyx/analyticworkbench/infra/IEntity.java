package io.scipionyx.analyticworkbench.infra;

import java.util.Date;

public interface IEntity {

	public String getId();

	public String getName();

	public String getDescription();

	public Long getVersion();

	public boolean isActive();

	public void setActive(boolean active);

	public void setCreated(Date time);

}
