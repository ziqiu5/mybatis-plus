package com.atguigu.plus.test;

import com.atguigu.plus.mapper.ProductMapper;
import com.atguigu.plus.pojo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * ClassName: MybtisxTest
 * Package: com.atguigu.plus.test
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/2/3 - 14:38  14:38
 * @Version: v1.0
 */

@SpringBootTest
public class MybatisTest {

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void test01(){
        int result = productMapper.insertSelective(new Product(null, "小新air4", 56000, null));
        System.out.println("result = " + result);

    }
    @Test
    public void test02(){
        List<Product> list = productMapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    public void test03(){
        int result = productMapper.deleteById(3);
        System.out.println("result = " + result);
    }


}
