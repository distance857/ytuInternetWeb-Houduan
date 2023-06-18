package com.example.internetwork.entity;

import lombok.Data;

@Data
public class ProductByCategory {
    private String image;
    private double price;
    private String title;
    private Integer id;

    public ProductByCategory(String image, double price, String title, Integer id) {
        this.image = image;
        this.price = price;
        this.title = title;
        this.id = id;
    }
}
