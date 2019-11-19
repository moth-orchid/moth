package com.briup.dao.mapperInterface;

import com.briup.common.bean.SCate;
import com.briup.common.bean.SCateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SCateMapper {
    int countByExample(SCateExample example);

    int deleteByExample(SCateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SCate record);

    int insertSelective(SCate record);

    List<SCate> selectByExample(SCateExample example);

    SCate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SCate record, @Param("example") SCateExample example);

    int updateByExample(@Param("record") SCate record, @Param("example") SCateExample example);

    int updateByPrimaryKeySelective(SCate record);

    int updateByPrimaryKey(SCate record);
}