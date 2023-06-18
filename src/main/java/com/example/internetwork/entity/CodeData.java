package com.example.internetwork.entity;

import lombok.Data;

@Data
public class CodeData {
    private String province;
    private String city;
    private String area;

    public CodeData() {
    }

    public CodeData(String province, String city, String area) {
        this.province = province;
        this.city = city;
        this.area = area;
    }

    public String getProvince() {
        return province != null ? province : "";
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return province != null ? province : "";
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area != null ? area : "";
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Data{" +
                "province=" + (province != null ? province : "") +
                ", city=" + (city != null ? city : "") +
                ", area=" + (area != null ? area : "") +
                '}';
    }

}
