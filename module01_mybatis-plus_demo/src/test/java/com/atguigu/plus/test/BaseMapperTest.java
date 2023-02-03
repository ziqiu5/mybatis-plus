package com.atguigu.plus.test;

import com.atguigu.plus.pojo.User;
import com.atguigu.plus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * ClassName: BaseMapperTest
 * Package: com.atguigu.plus.test
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/2/1 - 12:02  12:02
 * @Version: v1.0
 */

@SpringBootTest
public class BaseMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertTest(){
        int res = userMapper.insert(new User(null, "ziqiu", 20, "ziqiu@qq.com",null,null));
        System.out.println("res = " + res);
    }

    @Test
    public void deleteTest(){
//        int result = userMapper.deleteById(2);
//        System.out.println("result = " + result);
        int res = userMapper.deleteBatchIds(Arrays.asList(1, 3, 5));
        System.out.println("res = " + res);
    }

    @Test
    public void updateTest(){
        int res = userMapper.updateById(new User(4L, "张珊", 19, "1775333@baidu.com",null,null));
        System.out.println("res = " + res);
    }

    @Test
    public void queryTest(){
//        List<User> users = userMapper.selectList(null);
//        users.forEach(System.out::println);
//        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 3, 7));
//        users.forEach(System.out::println);
        User user = userMapper.selectById(5);
        System.out.println(user);

    }



}
