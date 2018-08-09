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

    // 查看购物车是否有相同商品
    ShopCart selectGoodsByShopCart(Map map);

    int addGoodsToShopCart(Map map);

    // 查看购物车
    List viewShopCart(Map map);

    int updateByStatusAndId(Integer shopCart);

    int updateByStatus(Integer status);

    int delectByStatus();

    List viewShopCartToOrder();

    // 改变购物车商品数量
    int changeShopCartGoodsNum(Map map);

}