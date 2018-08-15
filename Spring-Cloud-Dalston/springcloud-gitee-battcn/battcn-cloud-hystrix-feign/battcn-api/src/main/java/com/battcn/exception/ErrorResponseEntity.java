package com.battcn.exception;

/**
 * @author Levin
 * @date 2017-08-07.
 */
public class ErrorResponseEntity {
    private Integer customCode;
    private String message;

    public ErrorResponseEntity(Integer customCode, String message) {
        super();
        this.customCode = customCode;
        this.message = message;
    }

    public Integer getCustomCode() {
        return customCode;
    }

    public void setCustomCode(Integer customCode) {
        this.customCode = customCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
