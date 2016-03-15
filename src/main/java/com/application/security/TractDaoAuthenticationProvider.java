package com.application.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Component;

import com.application.credentials.SecurityUserDetails;

@Component
public class TractDaoAuthenticationProvider extends DaoAuthenticationProvider{

	@Autowired
	private ShaPasswordEncoder shaPasswordEncoder;

	@Autowired
	private ReflectionSaltSource reflectionSaltSource;
	
	@Autowired
	private SecurityUserDetails userDetailService;
	
	@Override
	protected void doAfterPropertiesSet() throws Exception {
		setUserDetailsService(userDetailService);
		setPasswordEncoder(shaPasswordEncoder);
		setSaltSource(reflectionSaltSource);
		super.doAfterPropertiesSet();
	}
}
