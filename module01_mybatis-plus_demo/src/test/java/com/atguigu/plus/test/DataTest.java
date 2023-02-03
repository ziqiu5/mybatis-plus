package com.atguigu.plus.test;

import com.atguigu.plus.enums.GenderEnums;
import com.atguigu.plus.mapper.UserMapper;
import com.atguigu.plus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * ClassName: DataTest
 * Package: com.atguigu.plus.test
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/31 - 18:49  18:49
 * @Version: v1.0
 */

@SpringBootTest
public class DataTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void dataTest() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void test02(){
        User user = new User(null, "小黑4", 25, "xiaohei@xiaobai,com", null, GenderEnums.FEMALE);
        int result = userMapper.insert(user);
        System.out.println("result = " + result);
    }



}
