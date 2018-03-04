package io.scipionyx.analyticworkbench.backend.infra.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import io.scipionyx.analyticworkbench.backend.infra.AbstractService;
import io.scipionyx.analyticworkbench.infra.Entity;

@Deprecated
public abstract class AbstractRestController<ENTITY extends Entity, CRUD_REPOSITORY extends CrudRepository<ENTITY, String>, SERVICE extends AbstractService<ENTITY, CRUD_REPOSITORY>> {

	private @Autowired SERVICE service;

	public SERVICE getService() {
		return service;
	}

}
