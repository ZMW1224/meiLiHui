package com.lanou.mapper;

import com.lanou.model.Size;

import java.util.List;
import java.util.Map;

public interface SizeMapper {
    int deleteByPrimaryKey(Integer sizeId);

    int insert(Size record);

    int insertSelective(Size record);

    Size selectByPrimaryKey(Integer sizeId);

    int updateByPrimaryKeySelective(Size record);

    int updateByPrimaryKey(Size record);

    // 点击该商品的该尺码 根据商品id和尺码 查找到对应的商品数量和商品编号
    Map<String,Object> findCountAndNumByGoodsId(Size size);

    // 根据
    List<Size> findSizes(Integer goodSizeId);
}