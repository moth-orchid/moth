package com.briup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.common.bean.Orderline;
import com.briup.common.bean.OrderlineExample;
import com.briup.common.bean.SUser;
import com.briup.common.bean.SUserExample;
import com.briup.common.bean.SUserExample.Criteria;
import com.briup.dao.mapperInterface.OrderlineMapper;
import com.briup.dao.mapperInterface.SUserMapper;
import com.briup.service.OrderLineService;
import com.briup.unit.MyBatisSqlSessionFactory;

public class OrderLineServiceImpl implements OrderLineService{

	@Override
	public void insertOrderLine(Orderline order) {
		SqlSession openSession = MyBatisSqlSessionFactory.openSession();
		OrderlineMapper mapper = openSession.getMapper(OrderlineMapper.class);
		
		OrderlineExample example=new OrderlineExample();
		com.briup.common.bean.OrderlineExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andOrderIdEqualTo(order.getOrderId());
		
		List<Orderline> selectByExample = mapper.selectByExample(example);
		
		if(selectByExample==null||selectByExample.size()==0) {
			
			int insert = mapper.insert(order);
			openSession.commit();
			
		}
		
	}

	@Override
	public void deleteOrderLine(Orderline order) {
		SqlSession openSession = MyBatisSqlSessionFactory.openSession();
		OrderlineMapper mapper = openSession.getMapper(OrderlineMapper.class);
		
		OrderlineExample example=new OrderlineExample();
		com.briup.common.bean.OrderlineExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andOrderIdEqualTo(order.getOrderId());
		
		mapper.deleteByExample(example);
		openSession.commit();
	}


}
