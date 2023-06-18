package com.example.internetwork.service.impl;

import com.example.internetwork.entity.ProductByCategory;
import com.example.internetwork.mapper.ProductByCategoryMapper;
import com.example.internetwork.service.ProductByCategoryService;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

//    @Override
//    public List<ProductByCategory> list() {
//        TaskResultExample taskResultExample = new TaskResultExample();
//        taskResultExample.setOrderByClause("id");
//        return productByCategoryMapper.selectByExample(taskResultExample);
//    }

    @Override
    public PageInfo<ProductByCategory> findProductByPage(int pageNum, int pageSize, int search) {
        PageHelper.startPage(pageNum, pageSize);

        List<ProductByCategory> productList = productByCategoryMapper.getProductsByCategoryId(search);

//        PageInfo<ProductByCategory> pageInfo = new PageInfo<>(productList);
//        return new Page<>(productList, pageInfo.getTotal());
        return new PageInfo<>(productList);
    }


}
