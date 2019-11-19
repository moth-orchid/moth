package com.briup.service.impl;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.common.bean.Orderline;
import com.briup.common.bean.OrderlineExample;
import com.briup.common.bean.SOrder;
import com.briup.common.bean.SOrderExample;
import com.briup.common.bean.SOrderExample.Criteria;
import com.briup.dao.mapperInterface.OrderlineMapper;
import com.briup.dao.mapperInterface.SOrderMapper;
import com.briup.service.*;
import com.briup.unit.MyBatisSqlSessionFactory;
public class OrderServiceimpl implements OrderService{

	@Override
	public void insertOrderLine(SOrder order) {
		SqlSession openSession = MyBatisSqlSessionFactory.openSession();
		SOrderMapper mapper = openSession.getMapper(SOrderMapper.class);
		
	    SOrderExample example=new SOrderExample();
		example.createCriteria().andOrderidEqualTo(order.getOrderid());
		
		List<SOrder> selectByExample = mapper.selectByExample(example);
		
		if(selectByExample==null||selectByExample.size()==0) {
			
			int insert = mapper.insert(order);
			openSession.commit();
			
		}
		
	}

	@Override
	public void deleteOrderLine(SOrder order) {
		// TODO Auto-generated method stub
		
	}

}
