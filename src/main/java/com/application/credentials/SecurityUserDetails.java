package com.application.credentials;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.application.credentials.User;
import com.application.database.BaseImplementation;

@Service
public class SecurityUserDetails implements UserDetailsService {

	/*@Autowired
	private UserImplementationService userService; 
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userService.getUserByUserName(username);

		//System.out.println("User : "+user.getFirstName());
		if(user==null){
			System.out.println("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
		
		return user;
	}*/
	
	@Autowired
	private UserImplementationService userImplementationService ;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userImplementationService.getUserByUserName(username);
		if (user == null){
			System.out.println("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
		/*List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ADMIN"));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), new String(user.getPassword()), authorities);*/
		return user;
	}

}
