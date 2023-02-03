package com.atguigu.plus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: HelloController
 * Package: com.atguigu.plus.controller
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/2/3 - 11:24  11:24
 * @Version: v1.0
 */

@RestController
public class HelloController {

    @RequestMapping(value = "/")
    public String hello(){
        return "<h1>hello,springBoot2!</h1>";
    }

}
