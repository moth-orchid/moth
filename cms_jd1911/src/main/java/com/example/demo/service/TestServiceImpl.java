package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Test;
import com.example.demo.bean.TestExample;
import com.example.demo.bean.User;
import com.example.demo.bean.UserExample;
import com.example.demo.dao.TestMapper;
import com.example.demo.dao.UserMapper;
@Service
public class TestServiceImpl implements TestService{
	
	@Autowired
	public TestMapper testMapper;
	@Autowired
	public UserMapper userMapper;
	
	@Override
	public List<Test> findAll() {
		TestExample example=new TestExample();
		List<Test> selectByExample = testMapper.selectByExample(example);
		return selectByExample;
	}

	@Override
	public List<User> findAllUser() {
		UserExample userExample=new UserExample();
		List<User> selectByExample = userMapper.selectByExample(userExample);
		return selectByExample;
	}

	@Override
	public void addUser(User user) {
		userMapper.insert(user);
		
	}

	@Override
	public void deleteUser(Long id) {
		userMapper.deleteByPrimaryKey(id.intValue());
		
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateByPrimaryKey(user);
		
	}

}
