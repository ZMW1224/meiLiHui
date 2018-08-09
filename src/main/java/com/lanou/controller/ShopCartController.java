package com.lanou.controller;

import com.lanou.model.Goods;
import com.lanou.model.ShopCart;
import com.lanou.model.User;
import com.lanou.service.ShopCartService;
import com.lanou.util.ServerResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
public class ShopCartController {
    @Autowired
    private ShopCartService shopCartService;

    // 添加商品
    @RequestMapping("/addGoodsToShopCart")
    @ResponseBody
    public ServerResponse addGoodsToShopCart(int sizeId, int quantity, User user){
        Integer userId = user.getUserId();
        Map map = new HashMap();
        map.put("sizeId",sizeId);
        map.put("quantity",quantity);
        map.put("userId",userId);
        // 查询购物车是否有相同的商品
        ShopCart shopCart = shopCartService.selectGoodsByShopCart(map);
        // 购物车没有相同的商品
        if(shopCart == null){
            // 如果没有 添加到购物车
            int i = shopCartService.addGoodsToShopCart(map);
            if (i>0){
                return ServerResponse.createSuccess("添加成功",i);
            }
        }

        return  ServerResponse.createError(100,"不能重复添加");
    }

    // 查看购物车
    @RequestMapping("/viewShopCart")
    @ResponseBody
    public ServerResponse viewShopCart(User user){
        Integer userId = user.getUserId();
        Map map = new HashMap();
        map.put("userId",userId);
        List list = shopCartService.viewShopCart(map);
        System.out.println(list);
        if(list != null){
            return ServerResponse.createSuccess("查询成功",list);
        }
            return ServerResponse.createError(100,"查询失败");
    }


    //单个删除商品
    @RequestMapping("/deleteByPrimaryKey")
    @ResponseBody
    public ServerResponse deleteByPrimaryKey(Integer id){
        Integer isDelete = shopCartService.deleteByPrimaryKey(id);
        if (isDelete>0){
            return ServerResponse.createSuccess("删除成功",isDelete);
        }
        return ServerResponse.createError(100,"删除失败");
    }

    //改变商品的状态
    @RequestMapping("/updateByStatusAndId")
    @ResponseBody
    public ServerResponse updateByStatusAndId(@Param("auto") String auto){
        //创建int类型变量
        int status;
        //根据用户是否选中
        if (auto!=null){
            //如果选中赋值为1
            status=1;
            Integer isUpdate = shopCartService.updateByStatusAndId(status);
            if (isUpdate>0){
                return ServerResponse.createSuccess("状态已经改变",isUpdate);
            }
            return ServerResponse.createError(100,"改变失败");
        }else {
            //没有选中赋值为0
            status=0;
            Integer isUpdate = shopCartService.updateByStatusAndId(status);
            if (isUpdate>0){
                return ServerResponse.createSuccess("状态已经改变",isUpdate);
            }
            return ServerResponse.createError(100,"改变失败");
        }
    }

    //一次性改变商品的状态
    @RequestMapping("/updateByStatus")
    @ResponseBody
    public ServerResponse updateByStatus(@Param("auto") String auto){
        //创建int类型变量
        int status;
        //根据用户是否选中
        if (auto!=null){
            //如果选中赋值为1
            status=1;
            Integer isUpdateAll = shopCartService.updateByStatus(status);
            if (isUpdateAll>0){
                return ServerResponse.createSuccess("一次性改变状态",isUpdateAll);
            }
            return ServerResponse.createError(100,"1");
        }else {
            //没有选中赋值为0
            status=0;
            Integer isUpdateAll = shopCartService.updateByStatus(status);
            if (isUpdateAll>0){
                return ServerResponse.createSuccess("一次改变状态",isUpdateAll);
            }
            return ServerResponse.createError(100,"0");
        }

    }

    //删除状态为1的商品
    @RequestMapping("/delectByStatus")
    @ResponseBody
    public ServerResponse delectByStatus(){
        Integer isStatus = shopCartService.delectByStatus();
        if (isStatus>0){
            return ServerResponse.createSuccess("删除成功",isStatus);
        }
        return ServerResponse.createError(100,"删除失败");
    }




}
