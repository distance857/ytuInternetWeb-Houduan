package com.example.internetwork.controller;


import com.example.internetwork.entity.Category;
import com.example.internetwork.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*", maxAge = 3600)   //允许跨域访问
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/by")
    public ResponseEntity<?> getSubcategoriesById(@RequestParam("id") String id) {
        try {
            Integer categoryId = Integer.parseInt(id);
            List<Category> subcategories = categoryService.getSubcategoriesById(categoryId);
            List<List<Map<String, Object>>> categoryList = new ArrayList<>();
            List<Map<String, Object>> currentGroup = new ArrayList<>();
            for (Category category : subcategories) {
                Map<String, Object> categoryJson = new HashMap<>();
                categoryJson.put("id", category.getId());
                categoryJson.put("name", category.getName());
                currentGroup.add(categoryJson);
                if (currentGroup.size() == 8) {
                    categoryList.add(currentGroup);
                    currentGroup = new ArrayList<>();
                }
            }
            if (!currentGroup.isEmpty()) {
                categoryList.add(currentGroup);
            }
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("categoryList", categoryList);
            return ResponseEntity.ok(responseBody);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid category ID");
        }
    }
}