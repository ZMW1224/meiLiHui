package com.lanou.service;

import com.lanou.model.Activity;

import java.util.List;

public interface ActivityService {
     List<Activity> findByActivePrimaryTitle(String string);



     // 查看所有活动
     List<Activity> findAllActivity();

     // 添加新活动(卖家版)
     int insertSelective(Activity activity);

     // 修改更新活动(卖家版)
     int updateByPrimaryKeySelective(Activity record);

}
