package com.lanou.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.model.Category;
import com.lanou.service.CategoryService;
import com.lanou.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lanou on 2018/7/30.
 */
@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    /*接口...无限极分类查询*/
    @RequestMapping(value = "findByParentId")
    @ResponseBody
    public ServerResponse findByParentId(Integer id) {
        List<Category> categoryList = categoryService.findByParentId(id);
        if (categoryList.size() == 0) {
            return ServerResponse.createError(100, "查询失败无记录");
        } else {
            return ServerResponse.createSuccess("查询成功", categoryList);
        }
    }
}
