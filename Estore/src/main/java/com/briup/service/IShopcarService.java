package com.briup.service;

import java.util.List;

import com.briup.common.bean.SShopcartItem;

public interface IShopcarService {
	public void insertShopCar(SShopcartItem shopcar);
	public List<SShopcartItem> selectAllSShopcartItem(long id);
	void updateshopcar(SShopcartItem shopcar);
	Long selectShopCarByProductid(Long id);
	Long selectShopCarByProductid2(Long id);
	
}
