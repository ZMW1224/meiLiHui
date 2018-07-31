package com.lanou.service.impl;

import com.lanou.mapper.CategoryMapper;
import com.lanou.model.Category;
import com.lanou.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanou on 2018/7/30.
 */
@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public Category findById(Integer id) {
        Category category = categoryMapper.selectByPrimaryKey(id);
        List<Category> categoryList = categoryMapper.findByParentId(category.getCategoryId());
        category.setChildrenCategory(categoryList);
        return category;
    }

    /*递归 自己调用自己
     * 进一步查询 以自己id为parentId的分类集合
     * 再将其塞入自己的childrenCategory属性中(集合)
     * */
    public List<Category> findByParentId(Integer id) {
        List<Category> categoryList = categoryMapper.findByParentId(id);
        for (int i = 0; i < categoryList.size(); i++) {
            Category category = categoryList.get(i);
            List<Category> categoryList1 = findByParentId(category.getCategoryId());
            category.setChildrenCategory(categoryList1);
        }
        return categoryList;
    }

}
