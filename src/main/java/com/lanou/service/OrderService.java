package com.lanou.service;

import com.lanou.model.Order;

import java.util.List;

public interface OrderService {
    //向订单表中添加数据
    public Integer insert(Order order);
    //查询订单信息
    public List selectOrder();
}
