package io.scipionyx.analyticworkbench.backend.infra.security;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import io.scipionyx.analyticworkbench.infra.User;

public interface UserRepository extends ElasticsearchCrudRepository<User, String> {

	User findOneByUsername(String username);

}
