package io.scipionyx.analyticworkbench.gateway.user;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import io.scipionyx.analyticworkbench.infra.User;

public interface UserRepository extends ElasticsearchCrudRepository<User, String> {

	User findOneByUsername(String username);

}
