package com.lanou.controller;

import com.lanou.model.Size;
import com.lanou.service.SizeService;
import com.lanou.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by lanou on 2018/8/3.
 */
@Controller
@CrossOrigin
@RequestMapping(value = "size")
public class SizeController {
    @Autowired
    SizeService sizeService;

    /*
    * goodsSizeId
    * sizeName
    * 点击对应的尺码 反馈给前端
    * 此商品 + 尺码 => 库存数量 + 商品编号
    * */
    @ResponseBody
    @RequestMapping(value = "findCountAndNumByGoodsId")
    public ServerResponse findCountAndNumByGoodsId(Size size){
        Map<String,Object> map = sizeService.findCountAndNumByGoodsId(size);
        System.out.println("map:" + map);
        if (map.size() > 0){
            // 大于0则查询成功
            return ServerResponse.createSuccess("查询成功", map);

        }
        return ServerResponse.createError(100,"查询结果空");
    }
}
