package com.lanou.mapper;

import com.lanou.model.ShopCar;

public interface ShopCarMapper {
    int deleteByPrimaryKey(Integer shopcarId);

    int insert(ShopCar record);

    int insertSelective(ShopCar record);

    ShopCar selectByPrimaryKey(Integer shopcarId);

    int updateByPrimaryKeySelective(ShopCar record);

    int updateByPrimaryKey(ShopCar record);
}