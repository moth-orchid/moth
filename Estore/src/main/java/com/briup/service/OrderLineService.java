package com.briup.service;

import com.briup.common.bean.Orderline;

public interface OrderLineService {
	public void insertOrderLine(Orderline order);
	public void deleteOrderLine(Orderline order);
}
