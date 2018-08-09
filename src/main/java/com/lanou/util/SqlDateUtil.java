package com.lanou.util;

import java.sql.Date;

/**
 * Created by lanou on 2018/8/9.
 */
public class SqlDateUtil {

    public static Date getCurrentSqlDate(){
        // 先获取当前时间
        // 在转换成数据库支持的sqlDate类型
        Date sDate = new Date(new java.util.Date().getTime());
        return sDate;
    }
}
