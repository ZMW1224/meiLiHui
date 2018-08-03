package com.lanou.service;

import com.lanou.model.Activity;
import com.lanou.model.Goods;

import java.util.List;
import java.util.Map;

/**
 * Created by lanou on 2018/8/1.
 */
public interface GoodsService {

    // 搜索框模糊查询
    public List<Goods> findGoodsBySearchBox(String keyword);

    // 第一种、活动详情页面，条件查询展示商品
    public Activity findGoodsListByActibityId(Goods goods);

    // 第二种、搜索框进入的商品展示页面，不需要活动id,需要搜索框keyword
    public List<Goods> findGoodsWithoutActivity(Map map);

    // 第三种不包含activity，不包含模糊查询条件
    // 大前提 一级标题+二级标题
    // 可选勾选条件为 品牌+三级标题
    public List<Goods> findGoodsByGuide(Goods goods);

    // 根据所属活动的商品查询有哪些 品牌 or 三级标题
    public List<Goods> findBrandOrThirdTitleByGoods(Map map);

    // 浏览商品点击商品进入商品详情页面
    public Goods findGoodsInfo(Goods goods);
}