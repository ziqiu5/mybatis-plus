package com.atguigu.plus.test;

import com.atguigu.plus.mapper.UserMapper;
import com.atguigu.plus.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * ClassName: WrapTest
 * Package: com.atguigu.plus.test
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/2/2 - 10:42  10:42
 * @Version: v1.0
 */

@SpringBootTest
public class WrapTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //查询用户名包含无，年龄在20到30之间，邮箱信息不为null的用户信息
        queryWrapper.like("user_name","无" ).gt("age", 25).isNotNull("email");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test02(){
        //查询用户信息，按照年龄的降序排序，若年龄相同，则按照id升序排序
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age").orderByAsc("id");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test03(){
        //删除邮箱地址为null的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int result = userMapper.delete(queryWrapper);
        System.out.println("result = " + result);
    }

    @Test
    public void test04(){
        //将（年龄大于25并且用户名中包含有无）或邮箱为null的用户信息修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age", 25).like("user_name", "无").or().isNull("email");
        User newUser = new User(null, "aaaa", 29, "aaaa@qq.com", null,null);
        int result = userMapper.update(newUser, queryWrapper);
        System.out.println("result = " + result);
    }
    
    @Test
    public void test05(){
        //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name","a" ).and(wrapper->wrapper.gt("age",20 ).or().isNull("email"));
        User newUser = new User(null, "ccccc", 29, "cccc@qq.com", null,null);
        int result = userMapper.update(newUser, queryWrapper);
        System.out.println("result = " + result);
    }

    @Test
    public void test06(){
        //查询年龄大于20的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age",20 );
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }


}
