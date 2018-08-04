package com.lanou.service;

import java.util.List;
import java.util.Map;

public interface ShopCartService {
    // 添加商品
    public int addGoodsToShopCart(Map map);
    // 查看购物车
    public List viewShopCart();
}
