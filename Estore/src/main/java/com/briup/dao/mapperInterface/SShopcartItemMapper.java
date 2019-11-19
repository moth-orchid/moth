package com.briup.dao.mapperInterface;

import com.briup.common.bean.SShopcartItem;
import com.briup.common.bean.SShopcartItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SShopcartItemMapper {
    int countByExample(SShopcartItemExample example);

    int deleteByExample(SShopcartItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SShopcartItem record);

    int insertSelective(SShopcartItem record);

    List<SShopcartItem> selectByExample(SShopcartItemExample example);

    SShopcartItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SShopcartItem record, @Param("example") SShopcartItemExample example);

    int updateByExample(@Param("record") SShopcartItem record, @Param("example") SShopcartItemExample example);

    int updateByPrimaryKeySelective(SShopcartItem record);

    int updateByPrimaryKey(SShopcartItem record);
}