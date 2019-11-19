package com.briup.dao.mapperInterface;

import com.briup.common.bean.SProduct;
import com.briup.common.bean.SProductExample;
import com.briup.common.bean.SProductWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SProductMapper {
    int countByExample(SProductExample example);

    int deleteByExample(SProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SProductWithBLOBs record);

    int insertSelective(SProductWithBLOBs record);

    List<SProductWithBLOBs> selectByExampleWithBLOBs(SProductExample example);

    List<SProduct> selectByExample(SProductExample example);

    SProductWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SProductWithBLOBs record, @Param("example") SProductExample example);

    int updateByExampleWithBLOBs(@Param("record") SProductWithBLOBs record, @Param("example") SProductExample example);

    int updateByExample(@Param("record") SProduct record, @Param("example") SProductExample example);

    int updateByPrimaryKeySelective(SProductWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SProductWithBLOBs record);

    int updateByPrimaryKey(SProduct record);
}