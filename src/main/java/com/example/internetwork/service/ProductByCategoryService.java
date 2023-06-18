package com.example.internetwork.service;

import com.example.internetwork.entity.ProductByCategory;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

public interface ProductByCategoryService {

    ArrayList<ProductByCategory> getProductByCategoryid(@PathVariable("id") int id);

    PageInfo<ProductByCategory> findProductByPage(int pageNum, int pageSize, int search);

//    Page<ProductByCategory> findProductByPage(int pageNum, int pageSize, int search);
}
