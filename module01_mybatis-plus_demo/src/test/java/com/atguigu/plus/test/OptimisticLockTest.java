package com.atguigu.plus.test;

import com.atguigu.plus.mapper.ProductMapper;
import com.atguigu.plus.pojo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * ClassName: OptimisticLockTest
 * Package: com.atguigu.plus.test
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/2/2 - 19:49  19:49
 * @Version: v1.0
 */

@SpringBootTest
public class OptimisticLockTest {

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void test01() {
        Product product1 = productMapper.selectById(1);
        System.out.println("小王查询时的product价格: " + product1.getPrice());
        Product product2 = productMapper.selectById(1);
        System.out.println("小陈查询时的product价格: " + product2.getPrice());

        System.out.println("===========小王进行价格的更变============");
        product1.setPrice(product1.getPrice().add(new BigDecimal(50)));
        productMapper.updateById(product1);

        System.out.println("==============小陈进行价格的变更====================");
        product2.setPrice(product2.getPrice().subtract(new BigDecimal(30)));
        int result = productMapper.updateById(product2);
        System.out.println(result > 0 ? "成功修改价格" : "修改失败");
        if(result == 0 ){
            //若修改失败 则获取到的不是最新的数据 需要重新获取数据再进行更改
            Product newProduct = productMapper.selectById(1);
            newProduct.setPrice(newProduct.getPrice().subtract(new BigDecimal(30)));
            productMapper.updateById(newProduct);
        }
        BigDecimal price = productMapper.selectById(1).getPrice();
        System.out.println("最新的价格====》 " + price);
    }


}
