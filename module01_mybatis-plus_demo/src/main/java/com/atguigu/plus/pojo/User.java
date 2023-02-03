package com.atguigu.plus.pojo;

import com.atguigu.plus.enums.GenderEnums;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ClassName: User
 * Package: com.atguigu.plus.pojo
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/31 - 18:47  18:47
 * @Version: v1.0
 */


@Data
@AllArgsConstructor
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("user_name")
    private String name;

    private Integer age;

    private String email;

    @TableLogic
    private Integer isDeleted;

    private GenderEnums gender;


}
