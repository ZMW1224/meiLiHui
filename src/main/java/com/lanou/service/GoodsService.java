package com.lanou.service;

import com.lanou.model.Activity;
import com.lanou.model.Goods;

import java.util.List;
import java.util.Map;

/**
 * Created by lanou on 2018/8/1.
 */
public interface GoodsService {
    // 活动详情页面，条件查询展示商品
    public Activity findGoodsListByActibityId(Goods goods);

    // 搜索框进入的商品展示页面，不需要活动id
    public List<Goods> findGoodsWithoutActivity(Goods goods);
}
