package com.lanou.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.model.Activity;
import com.lanou.model.Goods;
import com.lanou.service.GoodsService;
import com.lanou.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lanou on 2018/8/1.
 */
@Controller
@CrossOrigin
@RequestMapping(value = "goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    /*
    * 搜索框(模糊查询)
    * 搜索内容包括：
    *   一级标题(男士女士等) 则在页面展示品牌
    * */






    /*
    * 在活动列表中找到符合条件的商品
    * 点击活动，必定传入活动id=goodsActivityid(必选)
    * 在活动详情中有很多品牌、种类的商品
    * 勾选品牌、种类则 传入 品牌goodsBrand(可选)、种类goodsThirdtitle(可选)
    * 页码pages 想要查看第几页的数据(第一次打开默认为1，必选)
    * */
    @ResponseBody
    @RequestMapping(value = "findActivityToGoods")
    public ServerResponse findActivityToGoods(Goods goods, Integer pages){
        PageHelper.startPage(pages,10);
        System.out.println("传入的条件："+goods);
        Activity activity = goodsService.findGoodsListByActibityId(goods);
        System.out.println("activity:" + activity);
        if (activity != null){
            // 从活动中取出对应商品作分页
            List<Goods> goodsList = activity.getGoodsList();
            PageInfo pageInfo = new PageInfo(goodsList);
            // 先从pageinfo对象中取出分页后的goodsList
            List<Goods> pageGoodList = pageInfo.getList();
            // 再把做完分页后的商品塞入活动中
            activity.setGoodsList(pageGoodList);
            // 将activity对象变成一个list集合，准备放入pageInfo的集合属性中
            List<Activity> activityList = new ArrayList<Activity>();
            activityList.add(activity);
            // 再把活动对象塞入pageInfo中的list中
            pageInfo.setList(activityList);

            // 打印下瞧瞧
            System.out.println("结果集："+ pageInfo);
            // 结果不为null 则成功
            return ServerResponse.createSuccess("查询成功", pageInfo);

        }

        return ServerResponse.createError(100,"查询失败，结果为空");
    }

    /*
    * 从搜索框模糊查询得到的商品页面
    * 这里页面没有"活动"的概念
    * 所以 不需要传入活动id参数
    * 所需参数：
    *   三级标题 也就是种类goodsThirdtitle(可选)
    *   商品品牌 goodsBrand(可选)
    *   如果什么都不传，则查询出所有商品
    * */
    @ResponseBody
    @RequestMapping(value = "findGoodsWithoutActivity")
    public ServerResponse findGoodsWithoutActivity(Goods goods, Integer pages){
        // 设置分页，pages页码，pageSize每页数据量
        PageHelper.startPage(pages,12);
        System.out.println("传入的条件："+goods);
        List<Goods> goodsList = goodsService.findGoodsWithoutActivity(goods);
        // 打印一下商品瞧瞧
        for (Goods goods1 : goodsList) {
            System.out.println(goods1);
        }
        // 查询到的集合有内容则返回成功
        if (goodsList.size() > 0){
            PageInfo pageInfo = new PageInfo(goodsList);
            return ServerResponse.createSuccess("查询成功", pageInfo);
        }

        return ServerResponse.createError(100,"查询失败，结果为空");
    }
}
