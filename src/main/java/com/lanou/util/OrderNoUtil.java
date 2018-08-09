package com.lanou.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by lanou on 2018/8/9.
 */
public class OrderNoUtil {
    public static  String getOrderNo(){
        String orderNo = "" ;
        UUID uuid = UUID.randomUUID();
        String trandNo = String.valueOf((Math.random() * 9 + 1) * 1000000);
        String sdf = new SimpleDateFormat("yyyyMMddHHMMSS").format(new Date());
        orderNo = uuid.toString().substring(0, 8);
        orderNo = orderNo + sdf ;
        return orderNo ;
    }

}
