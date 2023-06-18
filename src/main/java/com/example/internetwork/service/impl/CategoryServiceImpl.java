package com.example.internetwork.service.impl;


import com.example.internetwork.entity.Category;
import com.example.internetwork.mapper.CategoryMapper;
import com.example.internetwork.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getSubcategoriesById(Integer id) {
        List<Category> subcategories = new ArrayList<>();
        getSubcategories(id, subcategories);
        return subcategories;
    }

    private void getSubcategories(Integer id, List<Category> subcategories) {
        List<Integer> categoryList = categoryMapper.getSubcategoriesById(id);
        if (categoryList != null && !categoryList.isEmpty()) {
            for (Integer categoryId : categoryList) {
                Category category = new Category();
                category.setId(categoryId);
                category.setName(categoryMapper.getCategoryById(categoryId));
                subcategories.add(category);
                getSubcategories(categoryId, subcategories);
            }
        }
    }
}