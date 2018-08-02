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


    // 搜索框模糊查询
    public List<Goods> findGoodsBySearchBox(String keyword){
        List<Goods> goodsList = goodsMapper.findGoodsBySearchBox(keyword);
        return goodsList;
    }

    // 一、活动详情页面，条件查询展示商品
    public Activity findGoodsListByActibityId(Goods goods){
        Activity act = goodsMapper.findActivityToGoodsById(goods);
        return act;
    }
    // 二、搜索框进入的商品展示页面，不需要活动id 需要keyword
    public List<Goods> findGoodsWithoutActivity(Map map){
        List<Goods> goodsList = goodsMapper.findGoodsWithoutActivity(map);
        return goodsList;
    }
    // 三、不包含activity，不包含模糊查询条件
    // 大前提 一级标题+二级标题
    // 可选勾选条件为 品牌+三级标题
    public List<Goods> findGoodsByGuide(Goods goods){
        List<Goods> goodsList = goodsMapper.findGoodsByGuide(goods);
        return goodsList;
    }

    // 根据所属活动的商品查询有哪些 品牌 or 三级标题
    public List<Goods> findBrandOrThirdTitleByGoods(Map map){
        List<Goods> thirdTitleList = goodsMapper.findBrandOrThirdTitleByGoods(map);
        return thirdTitleList;
    }
}
