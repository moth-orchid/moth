package com.example.demo.dao.extend;

import java.util.List;
import java.util.Map;

import com.example.demo.bean.Privilege;

public interface PrivilegeExtendMapper {
	List<Privilege> findByParentId(Long id);
	
	List<Privilege> findNull();
	
	
}
