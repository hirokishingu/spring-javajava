package com.spring.data.jpa.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.data.jpa.example.repository.AuthenticationRepository;
import com.spring.data.jpa.example.repository.entity.Authentication;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class AuthenticationDetailsService implements UserDetailsService {

	@Autowired
	private AuthenticationRepository authenticationRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Authentication authentication = authenticationRepository
															.findOne(username);

		if (authentication == null) {
			throw new UsernameNotFoundException("No employee present with employee no.: " + username);
		}

		return new AuthenticationDetail(authentication);
	}

}
