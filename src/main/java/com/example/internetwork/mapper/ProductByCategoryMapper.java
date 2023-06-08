package com.example.internetwork.mapper;

import com.example.internetwork.bean.ProductByCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.ArrayList;


@Mapper
public interface ProductByCategoryMapper {

    @Select("SELECT t_product.image,t_product.price,t_product.title,t_product.id FROM t_product where category_id = #{id}")
    ArrayList<ProductByCategory> getProductsByCategoryId(Integer id);
}
