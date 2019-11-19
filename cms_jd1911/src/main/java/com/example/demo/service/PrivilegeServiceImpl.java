package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Privilege;
import com.example.demo.bean.PrivilegeExample;
import com.example.demo.dao.PrivilegeMapper;
import com.example.demo.dao.extend.PrivilegeExtendMapper;

@Service
public class PrivilegeServiceImpl implements PrivilegeSevice{
	
	@Autowired
	private PrivilegeMapper privilegeMapper;
	
	@Autowired
	private PrivilegeExtendMapper privilegeExtendMapper;
	
	@Override
	public void deletePrivilegeById(Long id) {
		privilegeMapper.deleteByPrimaryKey(id.intValue());	
	}

	@Override
	public List<Privilege> findAllPrivilege() {
		PrivilegeExample example=new PrivilegeExample();
		List<Privilege> selectByExample = privilegeMapper.selectByExample(example);		
		return selectByExample;
	}

	@Override
	public void saveOrUpdate(Privilege privilege) {
		//判断权限id是否存在
		if(privilege.getId()!=null) {
			//是对权限进行更新
			privilegeMapper.updateByPrimaryKey(privilege);
		}else {
			privilegeMapper.insert(privilege);
		}
		
	}

	@Override
	public List<Privilege> findByParentId(Long id) {
		List<Privilege> findByParentId = privilegeExtendMapper.findByParentId(id);
		return findByParentId;
	}

	@Override
	public Map<Privilege, List<Privilege>> findPrivilegeTree() {
		Map<Privilege, List<Privilege>> map=new HashMap<>();
		//先查找所有父id为空的值作为map的键
		List<Privilege> findNull = privilegeExtendMapper.findNull();
		//遍历list集合，每一个值都作为健值
		for(Privilege p:findNull) {
			List<Privilege> findByParentId = privilegeExtendMapper.findByParentId(p.getId().longValue());
			map.put(p,findByParentId);
		}
		return map;
	}
	
}
