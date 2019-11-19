package com.briup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.common.bean.SUser;
import com.briup.common.bean.SUserExample;
import com.briup.common.bean.SUserExample.Criteria;
import com.briup.dao.mapperInterface.SUserMapper;
import com.briup.service.IUserService;
import com.briup.unit.MyBatisSqlSessionFactory;

public class LoginService implements IUserService{

	@Override
	public SUser findAllSUer(String username, String password) {
		SqlSession openSession = MyBatisSqlSessionFactory.openSession();
		System.out.println(openSession);
		
		SUserMapper mapper = openSession.getMapper(SUserMapper.class);
		SUserExample example=new SUserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUsernameEqualTo(username).andPasswordEqualTo(password);
		List<SUser> userlist = mapper.selectByExample(example);
		System.out.println("................");
		
		return userlist.get(0); 
	}
	
}
