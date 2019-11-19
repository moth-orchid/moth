package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.User;

public interface UserService {
	//查询所有用户
	List<User> findAllUser();
	
	//删除用户
	void deleteUserById(Long id);
	
	//保存或者更新用户
	void saveOrUpdate(User user);

	void setRoles(Long user_id, Long[] role_id);
}
