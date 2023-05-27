package com.example.internetwork.service.impl;

import com.example.internetwork.bean.Product;
import com.example.internetwork.mapper.ProductMapper;
import com.example.internetwork.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public Product getProduct(Integer id) {
        return productMapper.getProduct(id);
    }
}
