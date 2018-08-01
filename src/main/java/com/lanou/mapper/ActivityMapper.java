package com.lanou.mapper;

import com.lanou.model.Activity;

import java.util.List;

public interface ActivityMapper {
    int deleteByPrimaryKey(Integer activeId);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Integer activeId);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);
    //根据活动名字查询活动页面

    List<Activity> findByActivePrimaryTitle(String string);

}