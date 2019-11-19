package com.briup.dao.mapperInterface;

import com.briup.common.bean.SUser;
import com.briup.common.bean.SUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SUserMapper {
    int countByExample(SUserExample example);

    int deleteByExample(SUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SUser record);

    int insertSelective(SUser record);

    List<SUser> selectByExample(SUserExample example);

    SUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SUser record, @Param("example") SUserExample example);

    int updateByExample(@Param("record") SUser record, @Param("example") SUserExample example);

    int updateByPrimaryKeySelective(SUser record);

    int updateByPrimaryKey(SUser record);
}