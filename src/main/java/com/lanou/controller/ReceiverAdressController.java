package com.lanou.controller;

import com.lanou.mapper.ReceiverAdressMapper;
import com.lanou.model.ReceiverAdress;
import com.lanou.model.User;
import com.lanou.service.ReceiverAdressService;
import com.lanou.util.ServerResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@CrossOrigin
@RequestMapping("/receiver")
@Controller
public class ReceiverAdressController {
    @Autowired
    private ReceiverAdressService receiverAdressService;

    //用户添加收货地址
    @RequestMapping("/addReceiverAdress")
    @ResponseBody
    public ServerResponse addReceiverAdress(ReceiverAdress receiverAdress, HttpServletRequest request) {
        // 取出当前用户信息
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user1");
        // 获取当前用户的id
        Integer id = user.getUserId();
        // 存到receiverAdress中
        receiverAdress.setUserReceiverId(id);
        int i = receiverAdressService.insertSelective(receiverAdress);
        if (i > 0) {
            return ServerResponse.createSuccess("添加成功", i);
        }
        return ServerResponse.createError(100, "添加失败");
    }


    // 用户修改默认地址   status的状态为1时 为默认地址    status的状态为0时  不是默认地址
    public ServerResponse changeDefaultAdress(@Param("defa") String defa, int id) {
        // 点击了默认地址的复选框
        if (defa != null) {
            // 先查询出status为1的收货地址 是否存在
            ReceiverAdress receiverAdress = receiverAdressService.selectStatus(id);
            if (receiverAdress != null) {
                // 存在 修改status为0
                receiverAdressService.updateStatusOnClick(id);
                // 并将当前地址的status设置为1
                return ServerResponse.createSuccess("设置成功", "");
            } else {
                // 不存在 则直接设置status为0
                receiverAdressService.updateStatus(id);
                return ServerResponse.createSuccess("设置成功", "");
            }
        }
        return ServerResponse.createError(100, "设置失败");
    }
}

