package com.briup.dao.mapperInterface;

import com.briup.common.bean.SCateDetail;
import com.briup.common.bean.SCateDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SCateDetailMapper {
    int countByExample(SCateDetailExample example);

    int deleteByExample(SCateDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SCateDetail record);

    int insertSelective(SCateDetail record);

    List<SCateDetail> selectByExample(SCateDetailExample example);

    SCateDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SCateDetail record, @Param("example") SCateDetailExample example);

    int updateByExample(@Param("record") SCateDetail record, @Param("example") SCateDetailExample example);

    int updateByPrimaryKeySelective(SCateDetail record);

    int updateByPrimaryKey(SCateDetail record);
}