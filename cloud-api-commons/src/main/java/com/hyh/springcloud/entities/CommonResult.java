package com.hyh.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    Integer code;
    String message;
    T data;

    public CommonResult(Integer code, String message) {
        this(code,message,null);
    }
}
