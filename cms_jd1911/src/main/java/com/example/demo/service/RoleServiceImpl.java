package com.example.demo.service;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.bean.Role;
import com.example.demo.bean.RoleExample;
import com.example.demo.bean.RoleExample.Criteria;
import com.example.demo.dao.RoleMapper;
import com.example.demo.utils.CustomerException;
@Service
public class RoleServiceImpl implements RoleService{
	
	@Resource
	private RoleMapper roleMapper;
	
	@Override
	public void saveOrUpdateRole(Role role) {
		if(role.getId()==null) {
			//此处执行保存操作
			//判断用户名是否已经存在
			RoleExample example=new RoleExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andNameEqualTo(role.getName());
			List<Role> selectByExample = roleMapper.selectByExample(example);
			if(selectByExample.size()>0) {
				throw new CustomerException("该角色已经存在");
			}else {
				roleMapper.insert(role);
			}
		}else{
			roleMapper.updateByPrimaryKey(role);
		}		
	}

	@Override
	public void deleteRoleById(Long id) {
		roleMapper.deleteByPrimaryKey(id.intValue());
		
	}

	@Override
	public List<Role> findAll() {
		RoleExample example=new RoleExample();
		List<Role> roles = roleMapper.selectByExample(example);
		return roles;
	}

}
