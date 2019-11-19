package com.briup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.common.bean.SCate;
import com.briup.common.bean.SCateExample;
import com.briup.common.bean.SReport;
import com.briup.common.bean.SReportExample;
import com.briup.dao.mapperInterface.SCateMapper;
import com.briup.dao.mapperInterface.SReduceMapper;
import com.briup.dao.mapperInterface.SReportMapper;
import com.briup.service.IReportService;
import com.briup.unit.MyBatisSqlSessionFactory;

public class ReportServiceImpl implements IReportService{

	@Override
	public List<SReport> findAllReport() {
		SqlSession openSession = MyBatisSqlSessionFactory.openSession();
		SReportMapper mapper = openSession.getMapper(SReportMapper.class);
		SReportExample example=new SReportExample();

		List<SReport> report = mapper.selectByExample(example);
		return report;
	}

}
