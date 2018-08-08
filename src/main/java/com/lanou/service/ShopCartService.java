package com.lanou.service;

import com.lanou.model.ShopCart;

import java.util.List;
import java.util.Map;

public interface ShopCartService {
    // 添加商品
    public int addGoodsToShopCart(Map map);
    // 查看购物车
    public List viewShopCart();
    // 查看购物车是否有相同的商品
    public ShopCart selectGoodsByShopCart(Map map);

}
