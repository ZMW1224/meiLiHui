package com.lanou.service.impl;

import com.lanou.mapper.ShopCartMapper;
import com.lanou.model.ShopCart;
import com.lanou.model.User;
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
    public ShopCart selectGoodsByShopCart(Map map) {
        ShopCart shopCart = shopCartMapper.selectGoodsByShopCart(map);
        return shopCart;
    }

    // 添加商品
    public int addGoodsToShopCart(Map map) {
        int i = shopCartMapper.addGoodsToShopCart(map);
        return i;
    }

    // 改变购物车商品数量
    public int changeShopCartGoodsNum(Map map) {
        int i = shopCartMapper.changeShopCartGoodsNum(map);
        return i;
    }

    // 查看商品
    public List viewShopCart(Map map) {
        List list = shopCartMapper.viewShopCart(map);
        return list;
    }

    //单个删除商品
    public Integer deleteByPrimaryKey(Integer id) {
        int i = shopCartMapper.deleteByPrimaryKey(id);
        return i;
    }

    //单个改变商品的状态
    public Integer updateByStatusAndId(Integer shopCart) {
        int i = shopCartMapper.updateByStatusAndId(shopCart);
        return i;
    }

    //一次性改变商品的状态
    public Integer updateByStatus(Integer status) {
        int i = shopCartMapper.updateByStatus(status);
        return i;
    }

    //删除选中状态的商品status为1的
    public Integer delectByStatus() {
        int i = shopCartMapper.delectByStatus();
        return i;
    }

}
