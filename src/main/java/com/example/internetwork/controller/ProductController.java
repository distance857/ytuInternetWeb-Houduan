package com.example.internetwork.controller;

import com.example.internetwork.bean.Product;
import com.example.internetwork.bean.ProductByCategory;
import com.example.internetwork.service.ProductByCategoryService;
import com.example.internetwork.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*",maxAge = 3600)   //允许跨域访问
public class ProductController {

    @Resource
    private ProductService productService;

    @Resource
    private ProductByCategoryService productByCategoryService;

    @GetMapping("/getProduct")
    public Product getProduct(@RequestParam("id") Integer id){
        return productService.getProduct(id);
    }

    @GetMapping("/category/{id}")
    public ArrayList<ProductByCategory> getProductBycategoryid(@PathVariable ("id") Integer id){
        return productByCategoryService.getProductByCategoryid(id);
    }
}
