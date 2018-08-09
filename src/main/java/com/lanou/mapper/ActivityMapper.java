package com.lanou.mapper;

import com.lanou.model.Activity;

import java.util.List;

public interface ActivityMapper {
    int deleteByPrimaryKey(Integer activeId);

    int insert(Activity record);
    // 添加新活动
    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Integer activeId);
    // 修改更新活动(卖家版)
    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);
    //根据活动名字查询活动页面
    List<Activity> findByActivePrimaryTitle(String string);

    // 查询所有活动
    List<Activity> findAllActivity();
}