package com.atguigu.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ziqiu
 */
@SpringBootApplication
@MapperScan("com.atguigu.plus.mapper")
public class Module03MybatisxDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Module03MybatisxDemoApplication.class, args);
    }

}
