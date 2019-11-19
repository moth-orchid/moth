package com.briup.service;

import java.util.List;
import java.util.Map;

import com.briup.common.bean.SCate;
import com.briup.common.bean.SCateDetail;

/**
 * 一级目录和二级目录的service都在这里
 * @author CuiGX
 *
 */
public interface ICateService {
	
	/**
	 * 查询所有的一级目录
	 * @return 
	 */
	List<SCate> findAllCates();
	
	/**
	 * 查询所有的二级目录
	 * @return 
	 */
	List<SCateDetail> findAllCateDetails();
	
	/**
	 * 将整理好的分类信息返回出去
	 * 一级类目对应的二级类目整合成一个map
	 * @return
	 */
	Map<SCate, List<SCateDetail>> getCateDetailsInfo();
	
}










