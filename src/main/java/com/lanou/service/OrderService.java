package com.lanou.service;

import com.lanou.model.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
    //向订单表中添加数据
    public Integer insert(Map map);
    //查询地址
    public List selectReceiverAdress();

    public List viewShopCartOnOrder(Integer userId);

    public Integer updatePlaceReceipt(Integer id);
}
