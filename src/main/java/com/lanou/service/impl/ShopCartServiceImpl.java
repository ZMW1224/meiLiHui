package com.lanou.service.impl;

import com.lanou.mapper.ShopCartMapper;
import com.lanou.model.ShopCart;
import com.lanou.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("shopCartService")
public class ShopCartServiceImpl implements ShopCartService {

    @Autowired
    private ShopCartMapper shopCartMapper;
    // 查看购物车是否有相同的商品
    public ShopCart selectGoodsByShopCart(Map map){
      ShopCart shopCart = shopCartMapper.selectGoodsByShopCart(map);
      return shopCart;
    }

    // 添加商品
    public int addGoodsToShopCart(Map map){
        int i = shopCartMapper.addGoodsToShopCart(map);
       return i;
    }

    // 查看商品
    public List viewShopCart(){
      List list = shopCartMapper.viewShopCart();
        return list;
    }
}
