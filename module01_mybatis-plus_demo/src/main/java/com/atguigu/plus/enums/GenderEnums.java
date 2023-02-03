package com.atguigu.plus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * ClassName: GenderEnums
 * Package: com.atguigu.plus.enums
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/2/2 - 20:20  20:20
 * @Version: v1.0
 */
@Getter
@AllArgsConstructor
public enum GenderEnums {

    /**
     * MALE : 男
     * FEMALE : 女
     */
    MALE(0,"男"),FEMALE(1,"女");

    @EnumValue
    private Integer gender;
    private String genderName;

}
