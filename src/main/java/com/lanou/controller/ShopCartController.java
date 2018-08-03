package com.lanou.controller;

import com.lanou.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@Controller
public class ShopCartController {
    @Autowired
    private ShopCartService shopCartService;

    // 添加商品
    public void addGoodsToShopCart(int sizeId,int quantity){
        Map map = new HashMap();
        map.put("sizeId",sizeId);
        map.put("quantity",quantity);
        int i = shopCartService.addGoodsToShopCart(map);
    }

    // 查看购物车
}
