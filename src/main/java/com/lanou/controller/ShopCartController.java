package com.lanou.controller;

import com.lanou.model.Goods;
import com.lanou.service.ShopCartService;
import com.lanou.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
public class ShopCartController {
    @Autowired
    private ShopCartService shopCartService;

    // 添加商品
    @RequestMapping("/addGoodsToShopCart")
    @ResponseBody
    public ServerResponse addGoodsToShopCart(int sizeId,int quantity){
        Map map = new HashMap();
        map.put("sizeId",sizeId);
        map.put("quantity",quantity);
        int i = shopCartService.addGoodsToShopCart(map);
        if (i>0){
            return ServerResponse.createSuccess("添加成功",i);
        }
        return  ServerResponse.createError(100,"添加失败");
    }

    // 查看购物车
    @RequestMapping("/viewShopCart")
    @ResponseBody
    public ServerResponse viewShopCart(){
        List list = shopCartService.viewShopCart();
        if(list != null){
            return ServerResponse.createSuccess("查询成功",list);
        }
            return ServerResponse.createError(100,"查询失败");
    }
}