package com.battcn.exception;

/**
 * @author Levin
 * @date 2017-08-07.
 */
public enum ResponseCode {
    /**
     * 通用错误
     */
    COMMON_ERROR_CODE(400,"未知错误");

    private Integer code;
    private String message;

    public Integer code() {
        return code;
    }

    public String message() {
        return message;
    }

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
