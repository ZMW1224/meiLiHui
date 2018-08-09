package com.lanou.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.model.Activity;
import com.lanou.service.ActivityService;
import com.lanou.util.ServerResponse;
import com.lanou.util.SqlDateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
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







    /*
     * 以下代码属于
     * 卖家版
     * 后台管理系统
     */


    // 查看所有活动
    @ResponseBody
    @RequestMapping(value = "findAllActivity")
    public ServerResponse findAllActivity(Integer pages){
        // 给浏览的所有活动分页
        PageHelper.startPage(pages, 10);
        List<Activity> activityList = activityService.findAllActivity();
        if (activityList != null){
            PageInfo pageInfo = new PageInfo(activityList);
            return ServerResponse.createSuccess("查询成功", pageInfo);
        }
        return ServerResponse.createError(100, "查询结果为空");
    }


    // 添加 新活动
    @RequestMapping(value = "addActivity")
    @ResponseBody
    public ServerResponse insertActivity(Activity activity){
        // 活动创建时间初始为null 手动创建一个
        // 创建活动时让 更新时间=创建时间

        java.sql.Date sqlDate = SqlDateUtil.getCurrentSqlDate();
        // 将时间装进活动对象中
        activity.setCreatTime(sqlDate);
        activity.setUpdateTime(sqlDate);

        int isSuccess = activityService.insertSelective(activity);
        if (isSuccess == 1){
            // 如果isSuccess=1 则添加成功
            return ServerResponse.createSuccess("添加成功", isSuccess);
        }
        // 如果没成功则失败了
        return ServerResponse.createError(100, "添加失败");
    }

    // 更新 活动
    @RequestMapping(value = "updateActivityById")
    @ResponseBody
    public ServerResponse updateActivity(Activity activity){
        Date sqlDate = null;
        if (activity.getActiveId() != null){
            // 如果有传入活动id 才能作修改
            // 我们才进行更新数据库操作

            // 更新一下 更新时间 属性
            sqlDate = SqlDateUtil.getCurrentSqlDate();
            // 新时间装入活动对象的属性中
            activity.setUpdateTime(sqlDate);

            int isSuccess = activityService.updateByPrimaryKeySelective(activity);
            if (isSuccess == 1){
                // 如果isSuccess == 1则更新成功
                return ServerResponse.createSuccess("更新成功", isSuccess);
            }
        }
        // 如果没成功则失败
        return ServerResponse.createError(100, "更新失败");
    }
}