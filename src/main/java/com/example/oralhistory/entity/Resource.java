package com.example.oralhistory.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;


/**
 * @author Zmm
 * @since 2022-05-02
 */
@Data
@TableName("tb_resource")
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer type;
    private Integer status;
    private String url;
    private String title;
    private String synopsis;
    private String province;
    private String archives;
    private String theme;
    private LocalDate uptime;
    private String upercity;
    private String upername;
    private String upernumber;


}
