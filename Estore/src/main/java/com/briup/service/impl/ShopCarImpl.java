package com.briup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.common.bean.SShopcartItem;
import com.briup.common.bean.SShopcartItemExample;
import com.briup.common.bean.SShopcartItemExample.Criteria;
import com.briup.dao.mapperInterface.SShopcartItemMapper;
import com.briup.service.IShopcarService;
import com.briup.unit.MyBatisSqlSessionFactory;

public class ShopCarImpl implements IShopcarService{

	@Override
	public void insertShopCar(SShopcartItem shopcar) {
		//传入一个购物车对象
		SqlSession openSession = MyBatisSqlSessionFactory.openSession();
		SShopcartItemMapper mapper = openSession.getMapper(SShopcartItemMapper.class);
		
		Long id = shopcar.getUserId();
		System.out.println(id);
		//判断是否该用户已经加入了购物车
		List<SShopcartItem> product = selectAllSShopcartItem(id);
			for(SShopcartItem sc:product) {
				//如果有就更新数据库  数量加
				if(sc.getProductId()==shopcar.getProductId()) {
					
					shopcar.setId(sc.getId());
					updateshopcar(shopcar);
					return;
				}
			}
			
				int insert = mapper.insert(shopcar);
				openSession.commit();

	}

	@Override
	public List<SShopcartItem> selectAllSShopcartItem(long id) {
		SqlSession openSession = MyBatisSqlSessionFactory.openSession();
		SShopcartItemMapper mapper = openSession.getMapper(SShopcartItemMapper.class);
		
		SShopcartItemExample example=new SShopcartItemExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUserIdEqualTo(id);
		
		List<SShopcartItem> shopcar = mapper.selectByExample(example);
		return shopcar;
	}
	@Override
	public void updateshopcar(SShopcartItem shopcar) {
		SqlSession openSession = MyBatisSqlSessionFactory.openSession();
		SShopcartItemMapper mapper = openSession.getMapper(SShopcartItemMapper.class);
		
		//更新的时候 要现查看已经有的数量
		Long num = selectShopCarByProductid(shopcar.getProductId());
		Long num1=num+shopcar.getNum();
		shopcar.setNum(num1);
		
		SShopcartItemExample example=new SShopcartItemExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andProductIdEqualTo(shopcar.getProductId());
		
		mapper.updateByExample(shopcar, example);
		openSession.commit();
	 
	}
	@Override
	public Long selectShopCarByProductid(Long id) {
		SqlSession openSession = MyBatisSqlSessionFactory.openSession();
		SShopcartItemMapper mapper = openSession.getMapper(SShopcartItemMapper.class);
		
		//根据产品id查看数量
		SShopcartItemExample example=new SShopcartItemExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andProductIdEqualTo(id);
		
		List<SShopcartItem> shop = mapper.selectByExample(example);
		
		Long num=shop.get(0).getNum();
		return num;
	}
	@Override
	public Long selectShopCarByProductid2(Long id) {
		SqlSession openSession = MyBatisSqlSessionFactory.openSession();
		SShopcartItemMapper mapper = openSession.getMapper(SShopcartItemMapper.class);
		
		
		SShopcartItemExample example=new SShopcartItemExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andProductIdEqualTo(id);
		
		List<SShopcartItem> shop = mapper.selectByExample(example);
		
		Long num=shop.get(0).getId();
		return num;
	}
	
}
