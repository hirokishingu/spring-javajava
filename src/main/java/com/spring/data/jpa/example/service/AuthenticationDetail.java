package com.spring.data.jpa.example.service;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.spring.data.jpa.example.repository.entity.Authentication;

public class AuthenticationDetail extends User {
	public AuthenticationDetail(Authentication authentication) {
		super(
				authentication.getId(),
				authentication.getPassword(),
				true,
				authentication.getValidDate()
						.toLocalDate().compareTo(LocalDate.now()) >= 0,
				true,
				true,
				new ArrayList<GrantedAuthority>());
	}

}
