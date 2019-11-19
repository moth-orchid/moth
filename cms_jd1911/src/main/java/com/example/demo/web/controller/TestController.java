package com.example.demo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Test;
import com.example.demo.bean.User;
import com.example.demo.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	public TestService testService;
	
	@GetMapping("/test1")
	public List<Test> findAll(){
		List<Test> list = testService.findAll();
		
		return list;
	}
	@GetMapping("/findAllUser")
	public List<User> findAllUser(){
		List<User> list = testService.findAllUser();
		
		return list;
	}
	@GetMapping("/addUser")
	public void addUser(User user){
		/*
		 * User user=new User(); user.setUsername("rose"); user.setPassword("123");
		 * user.setRealname("hello"); testService.addUser(user);
		 */
		testService.addUser(user);
	}
	@GetMapping("/deleteUser")
	public void deleteUser(Long id){
		testService.deleteUser(id);
	}
	@GetMapping("/updateUser")
	public void updateUser(){
		User user=new User();
		user.setId(2);
		user.setUsername("rose");
		user.setPassword("79182");
		testService.updateUser(user);
	}
}
