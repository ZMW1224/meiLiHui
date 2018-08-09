package com.lanou.mapper;

import com.lanou.model.Order;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderId);
    //向订单中添加数据
    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    //查询订单
    List<Order> selectOrder();
}