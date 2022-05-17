package com.example.oralhistory.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 朱明名
 * @Date: 2022/05/17/20:39
 * @Description:
 */
@Data
@TableName("tb_admin")
public class Admin {
    @TableId(value = "id")
    Integer id;
    String name;
    String password;
}
