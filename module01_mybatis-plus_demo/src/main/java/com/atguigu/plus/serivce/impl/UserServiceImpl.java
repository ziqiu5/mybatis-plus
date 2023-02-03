package com.atguigu.plus.serivce.impl;

import com.atguigu.plus.pojo.User;
import com.atguigu.plus.mapper.UserMapper;
import com.atguigu.plus.serivce.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserServiceImpl
 * Package: com.atguigu.plus.serivce.impl
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/2/1 - 13:01  13:01
 * @Version: v1.0
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}
