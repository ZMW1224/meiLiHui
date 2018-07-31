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

}