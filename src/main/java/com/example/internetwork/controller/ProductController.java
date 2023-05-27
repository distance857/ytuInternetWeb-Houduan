package com.example.internetwork.controller;

import com.example.internetwork.bean.Product;
import com.example.internetwork.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*",maxAge = 3600)   //允许跨域访问
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping("/getProduct")
    public Product getProduct(@RequestBody Product product){
        return productService.getProduct(product.getId());
    }
}
