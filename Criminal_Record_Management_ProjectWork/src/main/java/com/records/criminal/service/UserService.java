package com.records.criminal.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.records.criminal.entity.User;
import com.records.criminal.model.UserRegistrationBean;

public interface UserService extends UserDetailsService {

	User save(UserRegistrationBean registrationBean);
}
