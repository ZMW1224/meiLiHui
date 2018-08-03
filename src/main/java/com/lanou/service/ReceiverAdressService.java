package com.lanou.service;

import com.lanou.model.ReceiverAdress;

public interface ReceiverAdressService {
    // 添加收货人地址
    public int insertSelective(ReceiverAdress receiverAdress);
    // 找出status为1的地址
    public ReceiverAdress selectStatus(int id);
    // 如果有 修改status为0
    public int updateStatusOnClick(int id);
    // 如果没有 直接设置status为1
    public int updateStatus(int id);

}
