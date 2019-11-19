package com.briup.dao.mapperInterface;

import com.briup.common.bean.Orderline;
import com.briup.common.bean.OrderlineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderlineMapper {
    int countByExample(OrderlineExample example);

    int deleteByExample(OrderlineExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Orderline record);

    int insertSelective(Orderline record);

    List<Orderline> selectByExample(OrderlineExample example);

    Orderline selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Orderline record, @Param("example") OrderlineExample example);

    int updateByExample(@Param("record") Orderline record, @Param("example") OrderlineExample example);

    int updateByPrimaryKeySelective(Orderline record);

    int updateByPrimaryKey(Orderline record);
}