package com.lanou.service.impl;

import com.lanou.mapper.SizeMapper;
import com.lanou.model.Size;
import com.lanou.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by lanou on 2018/8/3.
 */
@Service("SizeService")
public class SizeServiceImpl implements SizeService {
    @Autowired
    SizeMapper sizeMapper;

    /*查找对应尺码+数量 */
    public Map<String,Object> findCountAndNumByGoodsId(Size size) {
        Map<String,Object> map = sizeMapper.findCountAndNumByGoodsId(size);
        return map;
    }

    // 找到所属商品有哪些尺码  goodsInfo用
    public List<Size> findSizes(Integer goodsSizeId){
        List<Size> sizeList = sizeMapper.findSizes(goodsSizeId);
        return  sizeList;
    }
}
