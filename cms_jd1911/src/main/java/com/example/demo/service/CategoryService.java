package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.Category;
import com.example.demo.utils.CustomerException;

public interface CategoryService {
	List<Category> findAll();
	
	void saveOrUpdate(Category category) throws CustomerException;
	
	void deleteById(Long id) throws CustomerException;
	
	void batchDelete(Long[] ids) throws CustomerException;
}
