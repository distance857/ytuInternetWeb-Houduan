package com.example.internetwork.service.impl;

import com.example.internetwork.entity.Product;
import com.example.internetwork.mapper.ProductMapper;
import com.example.internetwork.service.ProductService;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public Product getProduct(Integer id) {
        return productMapper.getProduct(id);
    }

    @Override
    public void deleteById(Integer id) {
        productMapper.deleteById(id);
    }

    @Override
    public void updateById(Product product) {
        productMapper.updateByProduct(product);
    }


}
