package com.example.internetwork.entity;

import java.util.List;

public class Category {
    private Integer id;
    private String name;
    private String parent_id;
    private List<Category> childCategories;

    public Category() {
    }

    public Category(Integer id, String name, String parent_id, List<Category> childCategories) {
        this.id = id;
        this.name = name;
        this.parent_id = parent_id;
        this.childCategories = childCategories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public List<Category> getChildCategories() {
        return childCategories;
    }

    public void setChildCategories(List<Category> childCategories) {
        this.childCategories = childCategories;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parent_id='" + parent_id + '\'' +
                ", childCategories=" + childCategories +
                '}';
    }
}