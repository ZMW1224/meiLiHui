package com.lanou.service.impl;

import com.lanou.mapper.ShopCartMapper;
import com.lanou.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("shopCartService")
public class ShopCartServiceImpl implements ShopCartService {

    @Autowired
    private ShopCartMapper shopCartMapper;

    // 添加商品
    public int addGoodsToShopCart(Map map){
        int i = shopCartMapper.addGoodsToShopCart(map);
       return i;
    }
}
