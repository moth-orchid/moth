package com.briup.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.ibatis.session.SqlSession;

import com.briup.common.bean.SCate;
import com.briup.common.bean.SCateDetail;
import com.briup.common.bean.SCateDetailExample;
import com.briup.common.bean.SCateExample;
import com.briup.common.bean.SUser;
import com.briup.common.bean.SUserExample;
import com.briup.common.bean.SUserExample.Criteria;
import com.briup.dao.mapperInterface.SCateDetailMapper;
import com.briup.dao.mapperInterface.SCateMapper;
import com.briup.dao.mapperInterface.SUserMapper;
import com.briup.service.ICateService;
import com.briup.unit.MyBatisSqlSessionFactory;

public class CateServiceImpl implements ICateService {

	@Override
	public List<SCate> findAllCates() {
		SqlSession openSession = MyBatisSqlSessionFactory.openSession();
		SCateMapper mapper = openSession.getMapper(SCateMapper.class);
		SCateExample example=new SCateExample();

		List<SCate> selectByExample1 = mapper.selectByExample(example);
		return selectByExample1;
	}

	@Override
	public List<SCateDetail> findAllCateDetails() {
		SqlSession openSession = MyBatisSqlSessionFactory.openSession();
		SCateDetailMapper mapper = openSession.getMapper(SCateDetailMapper.class);
		SCateDetailExample example=new SCateDetailExample();
		
		List<SCateDetail> selectByExample2 = mapper.selectByExample(example);
		return selectByExample2;
	
	}

	@Override
	public Map<SCate, List<SCateDetail>> getCateDetailsInfo() {
		List<SCate> list1 = findAllCates();
		List<SCateDetail> list2 = findAllCateDetails();
		
		
		Map<SCate, List<SCateDetail>> map = new TreeMap<SCate, List<SCateDetail>>(new Comparator<SCate>() {

			public int compare(SCate arg0, SCate arg1) {
				return (int) (arg0.getId()-arg1.getId());
			}
		});
		
		//准备一个List集合		
		for(SCate s1 : list1) {
			List<SCateDetail> s2list = new ArrayList<SCateDetail>();
			for(SCateDetail s2 : list2) {
				if(s2.getCategoryId()==s1.getId()) {
					s2list.add(s2);
				}
			}
			map.put(s1, s2list);
		}
		return map;
	}

}
