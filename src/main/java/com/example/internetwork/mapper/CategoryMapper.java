package com.example.internetwork.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    List<Integer> getSubcategoriesById(Integer id);
    String getCategoryById(Integer id);
}
