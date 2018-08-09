package com.lanou.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.model.Activity;
import com.lanou.model.Goods;
import com.lanou.model.Size;
import com.lanou.service.GoodsService;
import com.lanou.service.SizeService;
import com.lanou.util.GuideGoods;
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
    @Autowired
    SizeService sizeService;


    /*
    * 搜索框(模糊查询)>>>>作废>>>>>该模糊查询和第二种商品展示的接口功能重复，见 findGoodsByKeyword
    * 搜索内容包括：
    *   分页 想要跳转到第几页 页码pages
    *   前端可以默认是第1页 刷新页面则从回第一页 为必须传入参数
    *   keyword 包括以下内容
    *   品牌goodsBrand
    *   一级标题goodsPrimarytitle
    *   二级标题goodsSecondtitle
    *   三级标题goodsThirdtitle
    * */
    @ResponseBody
    @RequestMapping(value = "findGoodsBySearchBox")
    public ServerResponse findBySearchBox(String keyword, Integer pages){
        PageHelper.startPage(pages,8);
        List<Goods> goodsList = goodsService.findGoodsBySearchBox(keyword);
        System.out.println(goodsList);

        if (goodsList.size() > 0){
            // 如果查到了物品集合 就做分页处理 并且返回成功
            PageInfo pageInfo = new PageInfo(goodsList);

            return ServerResponse.createSuccess("查询成功", pageInfo);
        }
        return ServerResponse.createError(100,"查询结果为0");
    }

    /*第一种
    * 在活动列表中找到符合条件的商品
    * 点击活动，必定传入活动id=goodsActivityid(必选)
    * 在活动详情中有很多品牌、种类的商品
    * 勾选品牌、三级标题则 传入 品牌goodsBrand(可选)、三级标题goodsThirdtitle(可选)
    * 页码pages 想要查看第几页的数据(第一次打开默认为1，必选)
    * */
    @ResponseBody
    @RequestMapping(value = "findActivityToGoods")
    public ServerResponse findActivityToGoods(Goods goods, Integer pages){
        // 分页
        PageHelper.startPage(pages,8);
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


            Map map = new HashMap();
            // 先查询品牌
            map.put("goodsActivityid", goods.getGoodsActivityid());
            // 将value变成数据库中字段 品牌
            map.put("brand_or_thirdTitle", "goods_brand");
            List<String> brandList = goodsService.findBrandOrThirdTitleWithId(map);

            // 在查询三级标题 将value替换成字段 三级标题
            map.put("brand_or_thirdTitle", "goods_thirdTitle");
            List<String> thirdTitleList = goodsService.findBrandOrThirdTitleWithId(map);

            // 将查询到的结果塞入activity中
            activity.setGoodsBrand(brandList);
            activity.setGoodsThirdtitle(thirdTitleList);

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
    @RequestMapping(value = "findGoodsByKeyword")
    public ServerResponse findGoodsWithoutActivity(Goods goods, Integer pages, String keyword){

        System.out.println("传入的条件："+goods);
        System.out.println("传入的关键词：" + keyword);
        Map map = new HashMap();
        // 无论有没有传标题和品牌，都放入map
        map.put("goodsBrand", goods.getGoodsBrand());
        map.put("goodsThirdtitle", goods.getGoodsThirdtitle());
        map.put("keyword",keyword);

        // 设置分页，pages页码，pageSize每页数据量
        PageHelper.startPage(pages,8);
        List<Goods> goodsList = goodsService.findGoodsWithoutActivity(map);

        GuideGoods guideGoods = new GuideGoods();
        List list = new ArrayList();

        Map map1 = new HashMap();
        // 先查品牌
        map1.put("keyword", keyword);
        map1.put("brand_or_thirdTitle", "goods_brand");
        List<String> brandList = goodsService.findBrandOrThirdTitleWithKeyword(map1);
        System.out.println(brandList);
        // 再查三级标题
        map1.put("brand_or_thirdTitle", "goods_thirdTitle");
        List<String> thirdTitleList = goodsService.findBrandOrThirdTitleWithKeyword(map1);
        System.out.println(brandList);

        // 查询到的集合有内容则返回成功
        if (goodsList.size() > 0){
            PageInfo pageInfo = new PageInfo(goodsList);
            guideGoods.setGoodsList(pageInfo.getList());
            guideGoods.setTotal(pageInfo.getTotal());
            guideGoods.setPages(pageInfo.getPages());
            guideGoods.setGoodsThirdtitle(thirdTitleList);
            guideGoods.setGoodsBrand(brandList);
            guideGoods.setKeyword(keyword);
            list.add(guideGoods);

            return ServerResponse.createSuccess("查询成功", list);
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
        /*+++++++++++++分页好用++++++++++++++*/
        System.out.println("goods:"+goods);
        System.out.println("pages:" + pages);
        PageHelper.startPage(pages,8);
        List<Goods> goodsList = goodsService.findGoodsByGuide(goods);
        // 查询到的商品
        System.out.println(goodsList);

        Map map = new HashMap();

        List list = new ArrayList();
        // 先查品牌
        map.put("goodsPrimarytitle", goods.getGoodsPrimarytitle());
        map.put("goodsSecondtitle", goods.getGoodsSecondtitle());
        map.put("brand_or_thirdTitle", "goods_brand");
        List<String> brandList = goodsService.findBrandOrThirdTitleWithGuide(map);
        System.out.println(brandList);
        // 再查三级标题
        map.put("brand_or_thirdTitle", "goods_thirdTitle");
        List<String> thirdTitleList = goodsService.findBrandOrThirdTitleWithGuide(map);
        System.out.println(thirdTitleList);

        GuideGoods guideGoods = null;
        if (goodsList.size() > 0){
            PageInfo pageInfo = new PageInfo(goodsList);
            guideGoods = new GuideGoods();
            guideGoods.setGoodsList(pageInfo.getList());

            guideGoods.setGoodsPrimarytitle(goods.getGoodsPrimarytitle());
            guideGoods.setGoodsSecondtitle(goods.getGoodsSecondtitle());

            guideGoods.setGoodsThirdtitle(thirdTitleList);
            guideGoods.setGoodsBrand(brandList);

            guideGoods.setPages(pageInfo.getPages());
            guideGoods.setTotal(pageInfo.getTotal());
            list.add(guideGoods);
            return ServerResponse.createSuccess("查询成功", list);
        }
        return ServerResponse.createError(100,"查询失败，数量为0");
    }


    /* 条件勾选 >>>>>>>作废>>>>>>> 有借鉴作用 暂留
    * 我们将 品牌and三级标题 都查出来 打包给前端
    * 参数有
    * goodsBrand、goodsThirdtitle、goodsActivityid、keyword、
    * goodsPrimarytitle、goodsSecondtitle
    *
    * goodsThirdtitle or goodsBrand
    * 对应数据库中查询字段
    * goods_thirdTitle or goods_brand
    * */
    @ResponseBody
    @RequestMapping(value = "findBrandOrThirdTitle")
    public ServerResponse findBrandOrThirdTitleByGoods(Goods goods, String keyword){
        Map map = new HashMap();
        Map mapReturn = new HashMap();
        // 第一种情况 前端传入的 goodsActivityid 不为空 则是第一种在活动中的商品
        if (goods.getGoodsActivityid() != null){
            // 先查询品牌
            map.put("goodsActivityid", goods.getGoodsActivityid());
            // 将value变成数据库中字段 品牌
            map.put("brand_or_thirdTitle", "goods_brand");
            List<String> brandList = goodsService.findBrandOrThirdTitleWithId(map);
            System.out.println("brandList：" + brandList);

            // 在查询三级标题 将value替换成字段 三级标题
            map.put("brand_or_thirdTitle", "goods_thirdTitle");
            List<String> thirdTitleList = goodsService.findBrandOrThirdTitleWithId(map);

            // 将查询出的品牌、三级标题 放入mapReturn中并返回
            mapReturn.put("goodsBrand", brandList);
            mapReturn.put("goodsThirdtitle", thirdTitleList);

            return ServerResponse.createSuccess("查询成功", mapReturn);
        }
        // 第二种情况 前端传入了keyword 说明当前商品展示页 是通过搜索框模糊查询的结果
        if (keyword != null){
            // 先查品牌
            map.put("keyword", keyword);
            map.put("brand_or_thirdTitle", "goods_brand");
            List<String> brandList = goodsService.findBrandOrThirdTitleWithKeyword(map);
            System.out.println(brandList);
            // 再查三级标题
            map.put("brand_or_thirdTitle", "goods_thirdTitle");
            List<String> thirdTitleList = goodsService.findBrandOrThirdTitleWithKeyword(map);
            // 将查询出的品牌、三级标题 放入mapReturn中并返回
            mapReturn.put("goodsBrand", brandList);
            mapReturn.put("goodsThirdtitle", thirdTitleList);

            return ServerResponse.createSuccess("查询成功", mapReturn);
        }
        // 第三种情况 前端传入了一级标题 二级标题 用户靠点击导航栏进入
        if(goods.getGoodsPrimarytitle() != null && goods.getGoodsSecondtitle() != null){
            // 先查品牌
            map.put("goodsPrimarytitle", goods.getGoodsPrimarytitle());
            map.put("goodsSecondtitle", goods.getGoodsSecondtitle());
            map.put("brand_or_thirdTitle", "goods_brand");
            List<String> brandList = goodsService.findBrandOrThirdTitleWithGuide(map);
            System.out.println(brandList);
            // 再查三级标题
            map.put("brand_or_thirdTitle", "goods_thirdTitle");
            List<String> thirdTitleList = goodsService.findBrandOrThirdTitleWithGuide(map);
            // 将查询出的品牌、三级标题 放入mapReturn中并返回
            mapReturn.put("goodsBrand", brandList);
            mapReturn.put("goodsThirdtitle", thirdTitleList);

            return ServerResponse.createSuccess("查询成功", mapReturn);
        }
        return ServerResponse.createError(100, "查询失败");
    }

    /* goodsInfo页面
    *
    * */
//    @ResponseBody
//    @RequestMapping(value = "findGoodsInfo")
//    public ServerResponse findGoodsInfo(Goods goods){
//        System.out.println("goodsId:"+goods.getGoodsId());
//        Goods goodsInfo = goodsService.findGoodsInfo(goods);
//        System.out.println("goodsInfo："+goodsInfo);
//        if (goodsInfo != null){
//            // 不为null则查询成功，
//            return ServerResponse.createSuccess("查询成功", goodsInfo);
//        }
//        return ServerResponse.createError(100, "查询结果为空");
//    }
    /*
    * goodsInfo页面
    * 将指定商品和对应尺码分别查询
    * 再把尺码塞入商品中
    * */
    @ResponseBody
    @RequestMapping(value = "findGoodsInfo")
    public ServerResponse findGoodsInfo(Goods goods){
        System.out.println("goodsId:"+goods.getGoodsId());
        Goods goodsInfo = goodsService.findGoodsInfo(goods);
        // 查找该商品有哪些尺码
        List<Size> sizeList = sizeService.findSizes(goods.getGoodsId());
        System.out.println(sizeList);
        // 尺码塞入商品
        goodsInfo.setSizes(sizeList);
        if (goodsInfo != null){
            // 不为null则查询成功，
            return ServerResponse.createSuccess("查询成功", goodsInfo);
        }
        return ServerResponse.createError(100, "查询结果为空");
    }
}
