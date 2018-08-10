package com.lanou.service.impl;

import com.lanou.mapper.OrderMapper;
import com.lanou.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    //添加商品到订单表(地址,购物车状态为1的商品,发票类型
    public Integer insert(Map map) {
        int i = orderMapper.insert(map);
        return i;
    }

    //查看地址
    public List selectReceiverAdress() {

        List list = orderMapper.selectReceiverAdress();
        return list;
    }

    //显示商品信息
    public List viewShopCartOnOrder(Integer userId){
        List list = orderMapper.viewShopCartOnOrder(userId);
        return list;
    }

    //改变收货地址

    public Integer updatePlaceReceipt(Integer id){
        int i = orderMapper.updatePlaceReceipt(id);
        return i;
    }
}
