package com.briup.dao.mapperInterface;

import com.briup.common.bean.SReduce;
import com.briup.common.bean.SReduceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SReduceMapper {
    int countByExample(SReduceExample example);

    int deleteByExample(SReduceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SReduce record);

    int insertSelective(SReduce record);

    List<SReduce> selectByExample(SReduceExample example);

    SReduce selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SReduce record, @Param("example") SReduceExample example);

    int updateByExample(@Param("record") SReduce record, @Param("example") SReduceExample example);

    int updateByPrimaryKeySelective(SReduce record);

    int updateByPrimaryKey(SReduce record);
}