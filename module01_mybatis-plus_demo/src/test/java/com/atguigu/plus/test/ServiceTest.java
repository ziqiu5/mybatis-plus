package com.atguigu.plus.test;

import com.atguigu.plus.pojo.User;
import com.atguigu.plus.serivce.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: ServiceTest
 * Package: com.atguigu.plus.test
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/2/1 - 13:03  13:03
 * @Version: v1.0
 */

@SpringBootTest
public class ServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void batchInsertTest(){
        List<User> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            User user = new User(10L + i, "无名" + i, 20 + i, "iiii@qq.com",null,null);
            list.add(user);
        }
        boolean res = userService.saveBatch(list);
        System.out.println("res = " + res);

    }


}
