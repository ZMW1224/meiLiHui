package com.lanou.service;


import com.lanou.model.ShopCart;

import java.util.List;
import java.util.Map;

public interface ShopCartService {
    // 添加商品
    public int addGoodsToShopCart(Map map);

    // 查看购物车
    public List viewShopCart(Map map);

    //单个删除购物车
    public Integer deleteByPrimaryKey(Integer id);

    //点击改变商品的状态
    public Integer updateByStatusAndId(Integer shopCart);

    //点击全选一次性改变商品的状态
    public Integer updateByStatus(Integer status);

    //删除选中状态的商品
    public Integer delectByStatus();

    public ShopCart selectGoodsByShopCart(Map map);

    // 改变购物车商品数量
    public int changeShopCartGoodsNum(Map map);
}
