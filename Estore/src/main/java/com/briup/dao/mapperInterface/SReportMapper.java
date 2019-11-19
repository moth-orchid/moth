package com.briup.dao.mapperInterface;

import com.briup.common.bean.SReport;
import com.briup.common.bean.SReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SReportMapper {
    int countByExample(SReportExample example);

    int deleteByExample(SReportExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SReport record);

    int insertSelective(SReport record);

    List<SReport> selectByExample(SReportExample example);

    SReport selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SReport record, @Param("example") SReportExample example);

    int updateByExample(@Param("record") SReport record, @Param("example") SReportExample example);

    int updateByPrimaryKeySelective(SReport record);

    int updateByPrimaryKey(SReport record);
}