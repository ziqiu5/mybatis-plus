package com.atguigu.plus.mapper;

import com.atguigu.plus.pojo.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
* @author ziqiu
* @description 针对表【t_product】的数据库操作Mapper
* @createDate 2023-02-03 14:32:55
* @Entity com.atguigu.plus.pojo.Product
*/
@Repository
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * 添加产品信息
     * @param product id=product
     * @return 返回受影响的行数
     */
    int insertSelective(@Param("product") Product product);



}




