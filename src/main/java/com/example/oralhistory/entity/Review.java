package com.example.oralhistory.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;


/**
 * @author Zmm
 * @since 2022-05-02
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_review")
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer status;
    private Integer resourceid;
    private String title;
    private String synopsis;
    private LocalDate uptime;
    private String upernumber;


}
