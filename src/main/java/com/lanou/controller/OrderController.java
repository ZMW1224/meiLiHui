package com.lanou.controller;

import com.lanou.model.Order;
import com.lanou.service.OrderService;
import com.lanou.service.ShopCartService;
import com.lanou.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ShopCartService shopCartService;

    @RequestMapping("/insert")
    @ResponseBody
    //向订单表中添加数据
    public ServerResponse insert(Order order){
        Integer isInsert = orderService.insert(order);
        if (isInsert>0){
            return ServerResponse.createSuccess("添加成功",isInsert);
        }
        return ServerResponse.createError(100,"添加失败");
    }

    @ResponseBody
    @RequestMapping("/selectOrder")
    //查询订单表的数据
    public ServerResponse selectOrder(){
        List orders = orderService.selectOrder();
        //创建map集合
        Map map = new HashMap();
        map.put("Order",orders);
        System.out.println(map);
        if (map.size()>0){
            return ServerResponse.createSuccess("订单信息查询成功",map);
        }
        return ServerResponse.createError(100,"查询失败");
    }
}
