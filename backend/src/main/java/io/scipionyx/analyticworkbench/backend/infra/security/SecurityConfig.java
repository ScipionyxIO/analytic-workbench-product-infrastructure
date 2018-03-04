package io.scipionyx.analyticworkbench.backend.infra.security;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@Configuration
// @EnableWebSecurity(debug = false)
@ComponentScan(basePackageClasses = { SecurityConfig.class })
// @EnableElasticsearchRepositories(basePackageClasses = { SecurityConfig.class
// })
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {
	// extends WebSecurityConfigurerAdapter {

	// private @Autowired UserService userService;

	// private @Autowired PasswordEncoder encoder;

	// @Bean
	// public PasswordEncoder passwordEncoder() {
	// return new BCryptPasswordEncoder();
	// }

	// @Override
	// protected void configure(AuthenticationManagerBuilder auth) throws Exception
	// {
	// auth.userDetailsService(userService).passwordEncoder(encoder);
	// }

}
