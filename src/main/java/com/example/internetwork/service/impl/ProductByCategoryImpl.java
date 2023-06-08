package com.example.internetwork.service.impl;

import com.example.internetwork.bean.ProductByCategory;
import com.example.internetwork.mapper.ProductByCategoryMapper;
import com.example.internetwork.mapper.ProductMapper;
import com.example.internetwork.service.ProductByCategoryService;
import com.example.internetwork.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductByCategoryImpl implements ProductByCategoryService {

    @Resource
    private ProductByCategoryMapper productByCategoryMapper;

    @Override
    public ArrayList<ProductByCategory> getProductByCategoryid(int id) {

        return productByCategoryMapper.getProductsByCategoryId(id);
    }
}
