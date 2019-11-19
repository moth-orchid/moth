package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Category;
import com.example.demo.bean.CategoryExample;
import com.example.demo.bean.CategoryExample.Criteria;
import com.example.demo.dao.CategoryMapper;
import com.example.demo.utils.CustomerException;
@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public List<Category> findAll() {
		return categoryMapper.selectByExample(new CategoryExample());
	}

	@Override
	public void saveOrUpdate(Category category) throws CustomerException {
		if(category.getId()!=null) {
			categoryMapper.updateByPrimaryKey(category);
		}else {
			CategoryExample cate=new CategoryExample();
			Criteria createCriteria = cate.createCriteria();
			createCriteria.andNameEqualTo(category.getName());
			List<Category> selectByExample = categoryMapper.selectByExample(cate);
			if(selectByExample.size()>0) {
				throw new CustomerException("该栏目已经存在");
			}else {
				categoryMapper.insert(category);
			}
		}
		
	}

	@Override
	public void deleteById(Long id) throws CustomerException {
		Category category=categoryMapper.selectByPrimaryKey(id);
		if(category==null) {
			throw new CustomerException("你要删除的数据不存在");
		}else {
			categoryMapper.deleteByPrimaryKey(id);
		}
		
	}

	@Override
	public void batchDelete(Long[] ids) throws CustomerException {
		
		for(Long id:ids) {
			this.deleteById(id);
		}
		
	}
	
}
