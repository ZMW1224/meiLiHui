package com.lanou.service.impl;

import com.lanou.mapper.ActivityMapper;
import com.lanou.model.Activity;
import com.lanou.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("activityService")
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;

    public List<Activity> findByActivePrimaryTitle(String string) {

        //调用mapper层方法
        List<Activity> primaryTitleList = activityMapper.findByActivePrimaryTitle(string);

        return primaryTitleList;
    }





    // 查看所有活动
    public List<Activity> findAllActivity(){
        List<Activity> activityList = activityMapper.findAllActivity();
        return  activityList;
    }

    // 添加新活动(卖家版) 返回1or0 1则成功
    public int insertSelective(Activity activity){
        int isSuccess = activityMapper.insertSelective(activity);
        return isSuccess;
    }

    // 修改更新活动(卖家版) 返回1or0 1则成功
    public int updateByPrimaryKeySelective(Activity activity){
        int isSuccess = activityMapper.updateByPrimaryKeySelective(activity);
        return isSuccess;
    }
}