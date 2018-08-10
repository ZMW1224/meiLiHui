package com.lanou.controller;

import com.lanou.model.Order;
import com.lanou.model.User;
import com.lanou.service.OrderService;
import com.lanou.service.ShopCartService;
import com.lanou.util.OrderNoUtil;
import com.lanou.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/insert")
    @ResponseBody
    //向订单表中添加数据
    public ServerResponse insert(HttpServletRequest request,Integer orderReceiveradressId,Integer orderShopcartStatus){
        //生成订单号
        String orderNumber = OrderNoUtil.getOrderNo();
        System.out.println(orderNumber);
        //获取userId
        HttpSession session = request.getSession();
        User user1 = (User)session.getAttribute("user1");
        Integer orderUserId = user1.getUserId();
       //int orderUserId = 1;
        //创建map
        Map map = new HashMap();
        map.put("orderReceiveradressId",orderReceiveradressId);
        map.put("orderShopcartStatus",orderShopcartStatus);
        map.put("orderUserId",orderUserId);
        map.put("orderNumber",orderNumber);
        System.out.println(map);
        Integer isInsert = orderService.insert(map);
        if (isInsert>0){
            return ServerResponse.createSuccess("添加成功",isInsert);

        }
        return ServerResponse.createError(100, "添加失败");
    }

    @ResponseBody
    @RequestMapping("/selectOrder")
    public ServerResponse selectOrder(HttpServletRequest request){
        //查询地址
        List ordersAdress = orderService.selectReceiverAdress();
        HttpSession session = request.getSession();
        Integer user1 = (Integer)session.getAttribute("user1");
       // int user1 =1;
        //查询提交结算的商品
        List viewShopCartOnOrder = orderService.viewShopCartOnOrder(user1);
        //创建map集合
        Map map = new HashMap();
        map.put("ordersAdress",ordersAdress);
        map.put("viewShopCartOnOrder",viewShopCartOnOrder);
        System.out.println(map);
        if (map.size() > 0) {
            return ServerResponse.createSuccess("订单信息查询成功", map);
        }
        return ServerResponse.createError(100, "查询失败");
    }

    //改变收货地址
    @RequestMapping("/updatePlaceReceipt")
    @ResponseBody
    public ServerResponse updatePlaceReceipt(Integer id){
        System.out.println(id);
        Integer integer = orderService.updatePlaceReceipt(id);
        if (integer>0){
            return ServerResponse.createSuccess("地址修改成功",integer);
        }
        return ServerResponse.createError(100,"修改失败");
    }
}
