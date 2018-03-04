package io.scipionyx.analyticworkbench.gateway.user;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import io.scipionyx.analyticworkbench.infra.Authority;


public interface AuthorityRepository extends ElasticsearchCrudRepository<Authority, String> {

	Authority findByAuthority(String authority);

	long countByAuthority(String authority);

}
