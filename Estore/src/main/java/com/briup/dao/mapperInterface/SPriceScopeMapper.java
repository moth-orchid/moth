package com.briup.dao.mapperInterface;

import com.briup.common.bean.SPriceScope;
import com.briup.common.bean.SPriceScopeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SPriceScopeMapper {
    int countByExample(SPriceScopeExample example);

    int deleteByExample(SPriceScopeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SPriceScope record);

    int insertSelective(SPriceScope record);

    List<SPriceScope> selectByExample(SPriceScopeExample example);

    SPriceScope selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SPriceScope record, @Param("example") SPriceScopeExample example);

    int updateByExample(@Param("record") SPriceScope record, @Param("example") SPriceScopeExample example);

    int updateByPrimaryKeySelective(SPriceScope record);

    int updateByPrimaryKey(SPriceScope record);
}