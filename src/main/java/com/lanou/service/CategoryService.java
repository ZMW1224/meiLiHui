package com.lanou.service;

import com.lanou.model.Category;

import java.util.List;

/**
 * Created by lanou on 2018/7/30.
 */
public interface CategoryService {
    public Category findById(Integer id);
    public List<Category> findByParentId(Integer id);
}
