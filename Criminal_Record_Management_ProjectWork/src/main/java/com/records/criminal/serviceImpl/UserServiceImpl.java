package com.records.criminal.serviceImpl;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.records.criminal.entity.Role;
import com.records.criminal.entity.User;
import com.records.criminal.model.UserRegistrationBean;
import com.records.criminal.repository.UserRepository;
import com.records.criminal.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		 User user = userRepository.findByEmail(username);
	        if (user == null) {
	            throw new UsernameNotFoundException("Invalid username or password.");
	        }
	        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}

	@Override
	public User save(UserRegistrationBean registrationBean) {
		 
		User user = new User(registrationBean.getPosition(),registrationBean.getEmail(),passwordEncoder.encode(registrationBean.getPassword()),Arrays.asList(new Role("ADMIN")));
		
		return userRepository.save(user);
		
		
	}
	 private Collection < ? extends GrantedAuthority > mapRolesToAuthorities(Collection < Role > roles) {
	        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	    }
}
