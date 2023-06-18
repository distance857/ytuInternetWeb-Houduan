package com.example.internetwork.service;


import com.example.internetwork.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getSubcategoriesById(Integer id);

}