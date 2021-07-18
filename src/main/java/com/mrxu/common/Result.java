package com.mrxu.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jlxu@telenav.cn
 * @date 2021/7/1 16:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> Result<T> success(Integer code, String message, T data) {
        return new Result(code, message, data);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result(200, message, data);
    }

    public static <T> Result<T> success(T data) {
        return new Result(200, "success", data);
    }

    public static Result error(Integer code, String message) {
        return new Result(code, message, null);
    }

    public static Result error(Integer code, String message, Throwable throwable) {
        return new Result(code, message, throwable);
    }
}
