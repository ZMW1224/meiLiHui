package com.lanou.service;

import com.lanou.model.Size;

import java.util.List;
import java.util.Map;

/**
 * Created by lanou on 2018/8/3.
 */
public interface SizeService {
    Map<String,Object> findCountAndNumByGoodsId(Size size);
}
