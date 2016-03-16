package com.application.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.application.credentials.SecurityUserDetails;

@Configuration
@EnableWebSecurity
@ComponentScan("com.application")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private SecurityUserDetails userDetailService;
	
	@Autowired
	private MyDaoAuthenticationProvider provider;
	
	@Autowired
	private ShaPasswordEncoder shaPasswordEncoder;

	@Autowired
	private ReflectionSaltSource reflectionSaltSource;

	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {		
		/*auth.inMemoryAuthentication().withUser("first").password("11111").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("second").password("22222").roles("USER");*/
		//auth.userDetailsService(userDetailService);
		auth.authenticationProvider(provider);
		//auth.inMemoryAuthentication().withUser("te").password("22222").roles("ADMIN");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		/*http.authorizeRequests()
		.antMatchers("/home").permitAll()
		//.anyRequest().hasRole("ADMIN")
		.and().formLogin().loginPage("/home")
		.usernameParameter("username").passwordParameter("password")
		.and().logout().logoutUrl("/logout").logoutSuccessUrl("/logout")
		.and().exceptionHandling().accessDeniedPage("/acessDenied");*/
		
		http.authorizeRequests()
		.antMatchers("/products").hasRole("ADMIN")
		.and().formLogin().loginPage("/login").defaultSuccessUrl("/products").usernameParameter("username").passwordParameter("password").permitAll()
		.and().logout().logoutSuccessUrl("/logout")
		.and().exceptionHandling().accessDeniedPage("/error");
	}
}
