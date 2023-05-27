package com.example.internetwork.bean;

import lombok.Data;

@Data
public class Product {
    private Integer id;
    private Integer num;
    private String title;
    private String sell_point;
    private String item_type;
    private double price;

    public Product(Integer num, String title, String sell_point, String item_type, double price) {
        this.num = num;
        this.title = title;
        this.sell_point = sell_point;
        this.item_type = item_type;
        this.price = price;
    }

    public Product() {
    }
}
