package com.example.internetwork.service;

import com.example.internetwork.bean.ProductByCategory;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

public interface ProductByCategoryService {

    ArrayList<ProductByCategory> getProductByCategoryid(@PathVariable("id") int id);
}
