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
    *   分页 想要跳转到第几页 页码pages
    *   前端可以默认是第1页 刷新页面则从回第一页 为必须传入参数
    *
    *   品牌goodsBrand
    *   一级标题goodsPrimarytitle
    *   二级标题goodsSecondtitle
    *   三级标题goodsThirdtitle
    * */
    @ResponseBody
    @RequestMapping(value = "findGoodsBySearchBox")
    public ServerResponse findBySearchBox(String keyword, Integer pages){
        List<Goods> goodsList = goodsService.findGoodsBySearchBox(keyword);
        System.out.println(goodsList);

        if (goodsList.size() > 0){
            // 如果查到了物品集合 就做分页处理 并且返回成功
            PageHelper.startPage(pages,12);
            PageInfo pageInfo = new PageInfo(goodsList);

            return ServerResponse.createSuccess("查询成功", pageInfo);
        }
        return ServerResponse.createError(100,"查询结果为0");
    }

    /*第一种
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

        return ServerResponse.createError(100,"查询失败，数量为0");
    }

    /*第二种
    * 从搜索框模糊查询得到的商品页面
    * 这里页面没有"活动"的概念
    * 所以 不需要传入活动id参数
    * 所需参数：
    *   分页 想要跳转到第几页 页码pages
    *   前端可以默认是第1页 刷新页面则从回第一页 为必须传入参数
    *
    *   模糊查询的内容(大前提) keyword
    *   三级标题 goodsThirdtitle(可选)
    *   商品品牌 goodsBrand(可选)
    *   如果什么都不传，则查询出所有商品
    * */
    @ResponseBody
    @RequestMapping(value = "findGoodsWithoutActivity")
    public ServerResponse findGoodsWithoutActivity(Goods goods, Integer pages, String keyword){
        // 设置分页，pages页码，pageSize每页数据量
        PageHelper.startPage(pages,12);
        System.out.println("传入的条件："+goods);
        System.out.println("传入的关键词：" + keyword);
        Map map = new HashMap();
        // 无论有没有传标题和品牌，都放入map
        map.put("goodsBrand", goods.getGoodsBrand());
        map.put("goodsThirdtitle", goods.getGoodsThirdtitle());
        map.put("keyword",keyword);

        List<Goods> goodsList = goodsService.findGoodsWithoutActivity(map);
        // 打印一下商品瞧瞧
        for (Goods goods1 : goodsList) {
            System.out.println(goods1);
        }
        // 查询到的集合有内容则返回成功
        if (goodsList.size() > 0){
            PageInfo pageInfo = new PageInfo(goodsList);
            return ServerResponse.createSuccess("查询成功", pageInfo);
        }

        return ServerResponse.createError(100,"查询失败，数量为0");
    }

    // 第三种、不包含activity，不包含模糊查询条件
    // 分页 想要跳转到第几页 页码pages
    // 前端可以默认是第1页 刷新页面则从回第一页 为必须传入参数
    // 大前提 一级标题+二级标题    goodsPrimarytitle+goodsSecondtitle
    // 可选勾选条件为 品牌+三级标题  goodsBrand+goodsThirdtitle
    @ResponseBody
    @RequestMapping(value = "findGoodsByGuide")
    public ServerResponse findGoodsByGuide(Goods goods, Integer pages){

        List<Goods> goodsList = goodsService.findGoodsByGuide(goods);
        System.out.println(goodsList);
        if (goodsList.size() > 0){
            PageHelper.startPage(pages, 12);
            PageInfo pageInfo = new PageInfo(goodsList);
            return ServerResponse.createSuccess("查询成功", pageInfo);
        }
        return ServerResponse.createError(100,"查询失败，数量为0");
    }


    /* 条件勾选
    * 页面传过来Goods类的属性 必须的属性是，页面想要品牌还是三级标题
    * 品牌的话就以goodsThirdtitle为key值，传入内容不为空就好
    * 同理 三级标题以goodsBrand为key值
    *
    * goodsThirdtitle or goodsBrand
    * 对应数据库中查询字段
    * goods_thirdTitle or goods_brand
    * */
    @ResponseBody
    @RequestMapping(value = "findBrandOrThirdTitle")
    public ServerResponse findBrandOrThirdTitleByGoods(Goods goods){
        Map map = new HashMap();
        if (goods.getGoodsBrand() == null){
            // 如果品牌为null 那么穿的值是三级标题 那我们使用三级标题查询数据库
            map.put("brand_or_thirdTitle", "goods_thirdTitle");
            map.put("goodsActivityid", goods.getGoodsActivityid());
            System.out.println("brand_or_thirdTitle：" + map.get("brand_or_thirdTitle"));
            System.out.println("goodsActivityid：" + map.get("goodsActivityid"));
            List<Goods> list = goodsService.findBrandOrThirdTitleByGoods(map);
            System.out.println("list：" + list);
            if (list.size() > 0){
                return ServerResponse.createSuccess("查询成功", list);
            }
            return ServerResponse.createError(100, "三级标题查询数量为0");
        } else {
            // 如果品牌不为null 那么三级标题就为null 我们用品牌查询数据库
            map.put("brand_or_thirdTitle", "goods_brand");
            map.put("goodsActivityid", goods.getGoodsActivityid());
            System.out.println("brand_or_thirdTitle：" + map.get("brand_or_thirdTitle"));
            System.out.println("goodsActivityid：" + map.get("goodsActivityid"));
            List<Goods> list = goodsService.findBrandOrThirdTitleByGoods(map);
            System.out.println("list：" + list);
            if (list.size() > 0){
                return ServerResponse.createSuccess("查询成功", list);
            }
            return  ServerResponse.createError(100, "品牌查询数量为0");
        }
    }
}
