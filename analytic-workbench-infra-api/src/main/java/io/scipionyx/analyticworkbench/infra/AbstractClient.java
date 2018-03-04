package io.scipionyx.analyticworkbench.infra;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface AbstractClient<ENTITY> {

	@RequestMapping(path = "/", method = RequestMethod.GET)
	Resources<ENTITY> findAll();

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	Resource<ENTITY> findOne(@PathVariable("id") String id);

	@RequestMapping(path = "/", method = RequestMethod.POST)
	Resource<ENTITY> save(@RequestBody ENTITY entity);

	@RequestMapping(path = "/", method = RequestMethod.DELETE)
	Resource<ENTITY> delete(@RequestBody ENTITY entity);

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	Resource<ENTITY> delete(@PathVariable("id") String id);

}
