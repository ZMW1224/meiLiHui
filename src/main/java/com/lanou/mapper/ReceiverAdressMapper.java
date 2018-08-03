package com.lanou.mapper;

import com.lanou.model.ReceiverAdress;

public interface ReceiverAdressMapper {
    int deleteByPrimaryKey(Integer receiverId);

    int insert(ReceiverAdress record);

    int insertSelective(ReceiverAdress record);

    ReceiverAdress selectByPrimaryKey(Integer receiverId);

    int updateByPrimaryKeySelective(ReceiverAdress record);

    int updateByPrimaryKey(ReceiverAdress record);

    // 找出status为1的地址
     ReceiverAdress selectStatus(int id);
    // 如果有 修改status为0
     int updateStatusOnClick(int id);
    // 如果没有 直接设置status为1
     int updateStatus(int id);

}