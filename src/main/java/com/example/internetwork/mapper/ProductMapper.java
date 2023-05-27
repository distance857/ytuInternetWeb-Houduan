package com.example.internetwork.mapper;

import com.example.internetwork.bean.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProductMapper {

    @Select("select * from t_product where id = #{id}")
    Product getProduct(Integer id);
}
