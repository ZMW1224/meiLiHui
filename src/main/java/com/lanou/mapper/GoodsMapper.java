package com.lanou.mapper;

import com.lanou.model.Activity;
import com.lanou.model.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer goodsId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> findGoodsBySearchBox(String keyword);

    Activity findActivityToGoodsById(Goods goods);

    List<Goods> findGoodsWithoutActivity(Map map);

    List<Goods> findGoodsByGuide(Goods goods);

    List<Goods> findBrandOrThirdTitleByGoods(Map map);
}