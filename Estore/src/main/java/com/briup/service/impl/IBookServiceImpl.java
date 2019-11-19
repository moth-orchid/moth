package com.briup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.common.bean.SProduct;
import com.briup.common.bean.SProductExample;
import com.briup.common.bean.SShopcartItem;
import com.briup.common.bean.SShopcartItemExample;
import com.briup.common.bean.SShopcartItemExample.Criteria;
import com.briup.dao.mapperInterface.SProductMapper;
import com.briup.dao.mapperInterface.SShopcartItemMapper;
import com.briup.service.IBookService;
import com.briup.unit.MyBatisSqlSessionFactory;

public class IBookServiceImpl implements IBookService{

	@Override
	public List<SProduct> findAllBook() {
		SqlSession openSession = MyBatisSqlSessionFactory.openSession();
		SProductMapper mapper = openSession.getMapper(SProductMapper.class);
		
		SProductExample example=new SProductExample();
		List<SProduct> selectByExample = mapper.selectByExample(example);
		
		return selectByExample;

	}
	@Override
	public SProduct findBookById(Long id) {
		SqlSession openSession = MyBatisSqlSessionFactory.openSession();
		SProductMapper mapper = openSession.getMapper(SProductMapper.class);
		
		SProductExample example=new SProductExample();
		example.createCriteria().andIdEqualTo(id);
		
		List<SProduct> product = mapper.selectByExample(example);
		
		return product.get(0);

	}
	@Override
	public long findBookByName(String name) {
		SqlSession openSession = MyBatisSqlSessionFactory.openSession();
		SProductMapper mapper = openSession.getMapper(SProductMapper.class);
		
		SProductExample example=new SProductExample();
		example.createCriteria().andNameEqualTo(name);
		
		List<SProduct> product = mapper.selectByExample(example);
		
		return product.get(0).getId();

	}

}
