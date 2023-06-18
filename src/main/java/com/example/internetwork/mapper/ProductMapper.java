package com.example.internetwork.mapper;

import com.example.internetwork.entity.Product;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProductMapper {

    @Select("select * from t_product where id = #{id}")
    Product getProduct(Integer id);
    @Delete("delete from t_product where id = #{id}")
    void deleteById(Integer id);
    @Update("UPDATE t_product SET categoryid = #{product.categoryid}, num = #{product.num}, title = #{product.title}, sell_point = #{product.sell_point}, item_type = #{product.item_type}, price = #{product.price} WHERE id = #{product.id}")
    void updateByProduct(@Param("product") Product product);

}
