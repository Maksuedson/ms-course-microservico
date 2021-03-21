package com.example.hroauth.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.hroauth.entities.User;
import com.example.hroauth.feignclients.UserFeignClient;


@Service
public class UserService implements UserDetailsService {
	
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	public User findByEmail(String email) {
		User user = userFeignClient.findByEmail(email).getBody();
		if (user == null) {
			logger.error("Email nao encontrado: "+ email);
			throw new IllegalArgumentException("Email nao encontrado");
		}
		logger.info("Email encontrado: "+email);
		return user;		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeignClient.findByEmail(username).getBody();
		if (user == null) {
			logger.error("Email nao encontrado: "+ username);
			throw new UsernameNotFoundException("Email nao encontrado");
		}
		logger.info("Email encontrado: "+username);
		return user;
	}

}
