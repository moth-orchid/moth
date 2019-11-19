package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.Test;
import com.example.demo.bean.User;

public interface TestService {
	List<Test> findAll();

	List<User> findAllUser();

	void addUser(User user);

	void deleteUser(Long id);

	void updateUser(User user);
	
}
