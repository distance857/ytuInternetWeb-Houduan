package com.example.internetwork.controller;


import com.example.internetwork.common.Result;
import com.example.internetwork.entity.Product;
import com.example.internetwork.entity.ProductByCategory;
import com.example.internetwork.service.ProductByCategoryService;
import com.example.internetwork.service.ProductService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*", maxAge = 3600)   //允许跨域访问
public class ProductController {

    @Resource
    private ProductService productService;

    @Resource
    private ProductByCategoryService productByCategoryService;

    @GetMapping("/getProduct")
    public Product getProduct(@RequestParam("id") Integer id) {
        return productService.getProduct(id);
    }

    @GetMapping("/category/{id}")
    public ArrayList<ProductByCategory> getProductBycategoryid(@PathVariable ("id") Integer id){
        return productByCategoryService.getProductByCategoryid(id);
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Integer id) {
        productService.deleteById(id);
        return Result.success();
    }

    @PutMapping("/change")
    public Result<?> ChangeGoods(@RequestBody Product product) {
        productService.updateById(product);
        return Result.success();
    }

//    @GetMapping("/category/{id}")
//    public Result<?> findProductsByPage(@RequestParam(defaultValue = "1") int pageNum,
//                                     @RequestParam(defaultValue = "10") int pageSize,
//                                     @RequestParam(defaultValue = "") int search) {
//        Page<ProductByCategory> page = productByCategoryService.findProductByPage(pageNum, pageSize,search);
////        System.out.println(user.getUsername());
//        return Result.success(page);
//    }

    @GetMapping(value = "/category/{id}/{pageSize}/{pageNum}")
    public PageInfo<ProductByCategory> page(@PathVariable(value = "pageSize") Integer pageSize,
                                            @PathVariable(value = "pageNum") Integer pageNum,
                                            @PathVariable(value = "id") Integer cid) {
//        PageHelper.startPage(pageNum,pageSize);
//        List<ProductByCategory> ProductByCategoryList = productByCategoryService.list();
//        PageInfo<ProductByCategory> page = new PageInfo<>(ProductByCategoryList, 5);

        return productByCategoryService.findProductByPage(pageNum, pageSize, cid);
    }
}
