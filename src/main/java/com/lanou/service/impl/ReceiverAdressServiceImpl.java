package com.lanou.service.impl;

import com.lanou.mapper.ReceiverAdressMapper;
import com.lanou.model.ReceiverAdress;
import com.lanou.service.ReceiverAdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service("receiverAdressService")
public class ReceiverAdressServiceImpl implements ReceiverAdressService {
    @Autowired
    private ReceiverAdressMapper receiverAdressMapper;

    // 添加地址
    public int insertSelective(ReceiverAdress receiverAdress){
        int i = receiverAdressMapper.insertSelective(receiverAdress);
        return i;
    }
    // 修改默认地址  找出status为1的地址
    public ReceiverAdress selectStatus(int id){
        ReceiverAdress receiverAdress = receiverAdressMapper.selectStatus(id);
        return receiverAdress;
    }

    // 如果有 修改status为0
    public int updateStatusOnClick(int id){
        int i = receiverAdressMapper.updateStatusOnClick(id);
        return i;
    }

    // 如果没有 直接设置status为1
    public int updateStatus(int id){
        int i = receiverAdressMapper.updateStatus(id);
        return i;
    }

}
