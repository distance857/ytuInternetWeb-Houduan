package com.example.internetwork.service;


import com.example.internetwork.entity.Product;
import com.github.pagehelper.Page;

public interface ProductService {
    Product getProduct(Integer id);

    void deleteById(Integer id);
    void updateById(Product product);

}
