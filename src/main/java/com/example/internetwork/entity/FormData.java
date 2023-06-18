package com.example.internetwork.entity;

import lombok.Data;

@Data
public class FormData {
    private String name;
    private String address;
    private String phone;

    public FormData() {
    }

    public FormData(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name != null ? name : "";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address != null ? address : "";
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone != null ? phone : "";
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "FormData{" +
                "name='" + (name != null ? name : "") + '\'' +
                ", address='" + (address != null ? address : "") + '\'' +
                ", phone='" + (phone != null ? phone : "") + '\'' +
                '}';
    }
}
