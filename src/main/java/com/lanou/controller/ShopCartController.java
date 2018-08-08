package com.lanou.controller;

import com.lanou.model.Goods;
import com.lanou.model.ShopCart;
import com.lanou.model.User;
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
    public ServerResponse addGoodsToShopCart(int sizeId, int quantity, User user){
        Integer userId = user.getUserId();
        Map map = new HashMap();
        map.put("sizeId",sizeId);
        map.put("quantity",quantity);
        map.put("userId",userId);
        // 查询购物车是否有相同的商品
        ShopCart shopCart = shopCartService.selectGoodsByShopCart(map);
        // 购物车没有相同的商品
        if(shopCart == null){
            // 如果没有 添加到购物车
            int i = shopCartService.addGoodsToShopCart(map);
            if (i>0){
                return ServerResponse.createSuccess("添加成功",i);
            }
        }

        return  ServerResponse.createError(100,"不能重复添加");
    }

    // 查看购物车
    @RequestMapping("/viewShopCart")
    @ResponseBody
    public ServerResponse viewShopCart(User user){
        Integer userId = user.getUserId();
        Map map = new HashMap();
        map.put("userId",userId);
        List list = shopCartService.viewShopCart(user);
        System.out.println(list);
        if(list != null){
            return ServerResponse.createSuccess("查询成功",list);
        }
            return ServerResponse.createError(100,"查询失败");
    }

}
