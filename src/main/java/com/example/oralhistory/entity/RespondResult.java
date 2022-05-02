package com.example.oralhistory.entity;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 朱明名
 * @Date: 2022/05/02/21:28
 * @Description:
 */
@Data
public class RespondResult<T> implements Serializable {

    // 信息
    private String msg;
    // 数据
    private T data;

    // 成功返回
    public static ResponseEntity<Object> success(Object data){
        RespondResult<Object> result = new RespondResult<>();
        result.setData(data);
        return new ResponseEntity<>(data, HttpStatus.valueOf(200));
    }

    // 失败返回
    public static ResponseEntity<Object> error(String msg,Integer code){
        RespondResult<Object> result = new RespondResult<>();
        result.setMsg(msg);
        return new ResponseEntity<>(result,HttpStatus.valueOf(code));
    }
}
