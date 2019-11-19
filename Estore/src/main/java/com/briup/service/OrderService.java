package com.briup.service;

import com.briup.common.bean.Orderline;
import com.briup.common.bean.SOrder;

public interface OrderService {
	public void insertOrderLine(SOrder order);
	public void deleteOrderLine(SOrder order);
}
