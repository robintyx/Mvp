package cn.microvideo.framework3.project.entity;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> Result<T> success(T data, String message) {
        Result<T> r = new Result<>();
        r.setCode(200);
        r.setMessage(message);
        r.setData(data);
        return r;
    }

    public static <T> Result<T> fail(String message) {
        Result<T> r = new Result<>();
        r.setCode(500);
        r.setMessage(message);
        return r;
    }

    public static <T> Result<T> notFound(String message) {
        Result<T> r = new Result<>();
        r.setCode(404);
        r.setMessage(message);
        return r;
    }

    public boolean isSuccess() {
        return code == 200;
    }
}