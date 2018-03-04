package io.scipionyx.analyticworkbench.infra;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(createIndex = true, indexName = "scipionyx_core_entity", refreshInterval = "-1s", type = "user")
public class User extends Entity implements UserDetails {

	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	@JsonDeserialize(as = ArrayList.class, contentAs = Authority.class)
	private Collection<? extends GrantedAuthority> authorities;

	private boolean accountNonExpired;

	private boolean accountNonLocked;

	private boolean credentialsNonExpired;

	private boolean enabled;

}
