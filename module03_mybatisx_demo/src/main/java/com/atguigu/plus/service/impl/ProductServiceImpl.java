package com.atguigu.plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.plus.pojo.Product;
import com.atguigu.plus.service.ProductService;
import com.atguigu.plus.mapper.ProductMapper;
import org.springframework.stereotype.Service;

/**
 * @author ziqiu
 * @description 针对表【t_product】的数据库操作Service实现
 * @createDate 2023-02-03 14:32:56
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
        implements ProductService {

}




