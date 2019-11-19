package com.example.demo.bean.extend;

import java.util.List;

import com.example.demo.bean.Role;
import com.example.demo.bean.User;

public class UserRole extends User{
	private List<Role> list;

	public List<Role> getList() {
		return list;
	}

	public void setList(List<Role> list) {
		this.list = list;
	}
	
}
