package com.lanou.mapper;

import com.lanou.model.ShopCart;

import java.util.List;
import java.util.Map;

public interface ShopCartMapper {
    int deleteByPrimaryKey(Integer shopcartId);

    int insert(ShopCart record);

    int insertSelective(ShopCart record);

    ShopCart selectByPrimaryKey(Integer shopcartId);

    int updateByPrimaryKeySelective(ShopCart record);

    int updateByPrimaryKey(ShopCart record);

    // 添加商品
    int addGoodsToShopCart(Map map);
    // 查看购物车
    List viewShopCart();
}