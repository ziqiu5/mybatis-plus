package com.atguigu.plus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * ClassName: Product
 * Package: com.atguigu.plus.pojo
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/2/2 - 19:46  19:46
 * @Version: v1.0
 */

@Data
@AllArgsConstructor
@TableName("t_product")
public class Product {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private BigDecimal price;

    @TableField("VERSION")
    @Version
    private Integer version;
}
