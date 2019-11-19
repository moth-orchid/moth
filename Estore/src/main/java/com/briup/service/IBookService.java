package com.briup.service;

import java.util.List;

import com.briup.common.bean.SProduct;

public interface IBookService {
	public List<SProduct> findAllBook();

	SProduct findBookById(Long id);

	long findBookByName(String name);
}
