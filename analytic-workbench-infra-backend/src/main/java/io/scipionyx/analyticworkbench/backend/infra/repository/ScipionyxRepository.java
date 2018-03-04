package io.scipionyx.analyticworkbench.backend.infra.repository;

import java.io.Serializable;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

public interface ScipionyxRepository<T, ID extends Serializable> extends ElasticsearchCrudRepository<T, ID> {

	@Override
	<S extends T> S save(S s);

	@Override
	Iterable<T> findAll();

}
