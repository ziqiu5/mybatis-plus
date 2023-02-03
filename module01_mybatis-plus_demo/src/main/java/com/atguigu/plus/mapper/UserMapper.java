package com.atguigu.plus.mapper;

import com.atguigu.plus.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * ClassName: UserMapper
 * Package: com.atguigu.plus.mapper
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/31 - 18:48  18:48
 * @Version: v1.0
 */

@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据年龄查询用户列表，分页显示
     * @param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位
     * @param age 年龄
     * @return 返回Page对象
     */
    Page<User> selectPageVo(@Param("page") Page<User> page,@Param("age") Integer age);


}
