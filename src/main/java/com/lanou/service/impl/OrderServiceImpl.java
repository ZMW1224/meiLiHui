package com.lanou.service.impl;

import com.lanou.mapper.OrderMapper;
import com.lanou.model.Order;
import com.lanou.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    //添加商品到订单表(地址,支付方式,发票)
    public Integer insert(Order order){
        int i = orderMapper.insert(order);
        return i;
    }

    //查询订单信息
    public List selectOrder(){
        List<Order> list = orderMapper.selectOrder();
        return list;
    }
}
