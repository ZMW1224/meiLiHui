package com.lanou.controller;

import com.lanou.model.Activity;
import com.lanou.service.ActivityService;
import com.lanou.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value = "activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @RequestMapping(value = "findByActivePrimaryTitle")
    @ResponseBody
    public ServerResponse findByActivePrimaryTitle(String string) {
        //查询数据返回集合
        List<Activity> primaryTitlesList = activityService.findByActivePrimaryTitle(string);
        //判断
        if (primaryTitlesList != null) {
            return ServerResponse.createSuccess("显示数据", primaryTitlesList);
        }
        return ServerResponse.createError(100, "页面加载失败");
    }
}