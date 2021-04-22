package com.pack.SpringBootRoleBasedSecurity.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pack.SpringBootRoleBasedSecurity.model.Role;
import com.pack.SpringBootRoleBasedSecurity.model.User;
import com.pack.SpringBootRoleBasedSecurity.repository.RoleRepository;
import com.pack.SpringBootRoleBasedSecurity.repository.UserRepository;



@Service
public  class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public void save(User user) {
		
		user.setPassword(user.getPassword());
		
		userRepository.save(user);
	}

	@Override
	public User findByUsername(String username,String password) {
		return userRepository.findByUsernameAndPassword(username,password);
	}


	@Override
	public void saveRole(Iterable i) {
		roleRepository.saveAll(i);
	}
}
