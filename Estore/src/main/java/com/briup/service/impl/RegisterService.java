package com.briup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.common.bean.SUser;
import com.briup.common.bean.SUserExample;
import com.briup.common.bean.SUserExample.Criteria;
import com.briup.dao.mapperInterface.SUserMapper;
import com.briup.service.IRegister;
import com.briup.unit.MyBatisSqlSessionFactory;

public class RegisterService implements IRegister{
	@Override
	public SUser findAllSUer(SUser user) {
		SqlSession openSession = MyBatisSqlSessionFactory.openSession();
		System.out.println(openSession);
		SUserMapper mapper = openSession.getMapper(SUserMapper.class);
		SUserExample example=new SUserExample();
		Criteria createCriteria = example.createCriteria();
		Criteria andUsernameEqualTo = createCriteria.andUsernameEqualTo(user.getUsername());
		List<SUser> selectByExample = mapper.selectByExample(example);
		System.out.println("................");
		if(selectByExample==null||selectByExample.size()==0) {
			System.out.println(">>>>>>>>>>>>>>");
			int insert = mapper.insert(user);
			openSession.commit();
			return user;
		}else {
			return user;
		}
	}
}
