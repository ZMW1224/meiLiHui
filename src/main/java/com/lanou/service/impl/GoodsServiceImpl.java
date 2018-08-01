package com.lanou.service.impl;

import com.lanou.mapper.GoodsMapper;
import com.lanou.model.Activity;
import com.lanou.model.Goods;
import com.lanou.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by lanou on 2018/8/1.
 */
@Service("GoodsService")
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;


    // 活动详情页面，条件查询展示商品
    public Activity findGoodsListByActibityId(Goods goods){
        Activity act = goodsMapper.findActivityToGoodsById(goods);
        return act;
    }
    // 搜索框进入的商品展示页面，不需要活动id
    public List<Goods> findGoodsWithoutActivity(Goods goods){
        List<Goods> goodsList = goodsMapper.findGoodsWithoutActivity(goods);
        return goodsList;
    }
}
