package com.example.internetwork.entity;

import lombok.Data;

@Data
public class Product {
    private Integer id;
    private Integer categoryid;
    private Integer num;
    private String title;
    private String sell_point;
    private String item_type;
    private Integer price;

    public Product(Integer num, String title, String sell_point, String item_type, Integer price) {
        this.num = num;
        this.title = title;
        this.sell_point = sell_point;
        this.item_type = item_type;
        this.price = price;
    }

    public Product(Integer id, Integer categoryid, Integer num, String title, String sell_point, String item_type, Integer price) {
        this.id = id;
        this.categoryid = categoryid;
        this.num = num;
        this.title = title;
        this.sell_point = sell_point;
        this.item_type = item_type;
        this.price = price;
    }

    public Product() {
    }
}
