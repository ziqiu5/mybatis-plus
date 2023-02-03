package com.atguigu.plus.test;

import com.atguigu.plus.mapper.UserMapper;
import com.atguigu.plus.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * ClassName: PagePluginTest
 * Package: com.atguigu.plus.test
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/2/2 - 17:08  17:08
 * @Version: v1.0
 */

@SpringBootTest
@Slf4j
public class PagePluginTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {
        Page<User> page = userMapper.selectPage(new Page<>(1, 5), null);
        List<User> list = page.getRecords();
        System.out.println("是否有上一页: " + page.hasPrevious());
        System.out.println("是否有下一页: " + page.hasNext());
        log.info("总页数: {}",page.getPages());
        log.info("总记录数: {}", page.getTotal());
        log.info("当前页码: {}", page.getCurrent());
        log.info("每页显示记录数: {}", page.getSize());
        System.out.println("============当前页记录信息===========");
        list.forEach(System.out::println);
    }

    @Test
    public void test02() {
        Page<User> page = userMapper.selectPageVo(new Page<User>(1, 2), 20);
        List<User> users = page.getRecords();
        users.forEach(System.out::println);
    }

    @Test
    public void test03() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age", 20);
        Page<User> page = userMapper.selectPage(new Page<>(1, 3), queryWrapper);
        List<User> list = page.getRecords();
        System.out.println("是否有上一页: " + page.hasPrevious());
        System.out.println("是否有下一页: " + page.hasNext());
        System.out.println("总页数: " + page.getPages());
        System.out.println("总记录数: " + page.getTotal());
        System.out.println("当前页码；" + page.getCurrent());
        System.out.println("每页显示记录数；" + page.getSize());
        System.out.println("============当前页记录信息===========");
        list.forEach(System.out::println);
    }

    @Test
    public void test04() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.ge(User::getAge, 20).isNotNull(User::getEmail);
        List<User> list = userMapper.selectList(lambdaQueryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test05() {
        //将用户名中包含有c并且（年龄大于20或邮箱为null）的用户信息修改
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.like("user_name", "c").
                and(wrapper -> wrapper.gt("age", 20).or().isNull("email")).
                set("email", "atguigu@baidu.com");
        int result = userMapper.update(null, updateWrapper);
        System.out.println("result = " + result);
    }

    @Test
    public void test06() {
        //将用户名中包含有c并且（年龄大于20或邮箱为null）的用户信息修改
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.like(User::getName, "c").
                and(wrapper -> wrapper.gt(User::getAge, 25).or().isNull(User::getEmail)).
                set(User::getEmail, "atguigu@ziqiu.com");
        int result = userMapper.update(null, updateWrapper);
        System.out.println("result = " + result);
    }


}
