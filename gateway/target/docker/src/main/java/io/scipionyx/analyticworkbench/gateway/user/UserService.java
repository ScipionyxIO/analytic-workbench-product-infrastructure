package io.scipionyx.analyticworkbench.gateway.user;

import java.util.Arrays;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import io.scipionyx.analyticworkbench.infra.Authorities;
import io.scipionyx.analyticworkbench.infra.Authority;
import io.scipionyx.analyticworkbench.infra.User;

@Component
public class UserService implements UserDetailsService {

	private @Autowired UserRepository userRepository;

	private @Autowired AuthorityRepository authorityRepository;

	private @Autowired PasswordEncoder passwordEncoder;

	private @PostConstruct void init() {

		// Simple Granted Authority
		Arrays.asList(Authorities.values()).stream()
				.filter(role -> authorityRepository.countByAuthority(role.toString()) == 0).forEach(
						role -> authorityRepository.save(new Authority(UUID.randomUUID().toString(), role.toString())));

		// Bootstrap User
		User findOneByUsername = userRepository.findOneByUsername("bootstrap");
		if (findOneByUsername == null) {
			User user = new User();
			user.setId(UUID.randomUUID().toString());
			user.setUsername("bootstrap");
			user.setPassword(passwordEncoder.encode("bootstrap"));
			user.setAccountNonExpired(true);
			user.setAccountNonLocked(true);
			user.setCredentialsNonExpired(true);
			user.setEnabled(true);
			user.setAuthorities(Arrays.asList(authorityRepository.findByAuthority(Authorities.BOOTSTRAP.toString()),
					authorityRepository.findByAuthority(Authorities.ROLE_BOOTSTRAP.toString())));
			userRepository.save(user);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
		return userRepository.findOneByUsername(user);
	}
}