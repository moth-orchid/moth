package com.example.demo.dao.extend;

import java.util.List;

import com.example.demo.bean.Role;

public interface RoleExtendMapper {
	List<Role> findByUserId(Long id);
}
