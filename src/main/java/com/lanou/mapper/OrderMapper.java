package com.lanou.mapper;

import com.lanou.model.Order;

import java.util.List;
import java.util.Map;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Map map);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    //查看地址
     List selectReceiverAdress();

     List viewShopCartOnOrder(Integer map);

     int updatePlaceReceipt(Integer id);

}