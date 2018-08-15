package com.battcn.exception;

import java.text.MessageFormat;

/**
 * @author Levin
 */
public class BattcnException extends RuntimeException {

    private static final long serialVersionUID = 2097203318701175031L;

    public static final int BAD_REQUEST = 400;
    public static final int FORBIDDEN = 403;
    public static final int NOT_FOUND = 404;
    public static final int RESOURCE_REPLICATION = 409;
    public static final int COMMON_CUSTOM_CODE = 400;

    /**
     * 规范的HTTP状态响应码,如400/403/503等
     */
    private transient int code;
    /**
     * 自定义返回码
     */
    private int customCode;


    /**
     * 会替换参数占位符
     *
     * @param message   模板编码{0}不存在
     * @param arguments LOVE
     * @return 模板编码LOVE不存在
     */
    public static BattcnException badRequest(String message, Object... arguments) {
        return new BattcnException(BAD_REQUEST, MessageFormat.format(message, arguments));
    }

    public static BattcnException badRequest(String message) {
        return new BattcnException(BAD_REQUEST, message);
    }

    public static BattcnException badRequest(ResponseCode responseCode) {
        return new BattcnException(BAD_REQUEST, responseCode.code(), responseCode.message());
    }

    public static BattcnException badRequest(Integer customCode, String message) {
        return new BattcnException(BAD_REQUEST, customCode, message);
    }

    public static BattcnException notFound(String message, Object... arguments) {
        return new BattcnException(NOT_FOUND, MessageFormat.format(message, arguments));
    }

    public static BattcnException notFound(String message) {
        return new BattcnException(NOT_FOUND, message);
    }

    public static BattcnException notFound(ResponseCode responseCode) {
        return new BattcnException(NOT_FOUND, responseCode.code(), responseCode.message());
    }

    public static BattcnException notFound(Integer customCode, String message) {
        return new BattcnException(NOT_FOUND, customCode, message);
    }


    public BattcnException(String message) {
        super(message);
        this.setCustomCode(BAD_REQUEST);
        this.setCode(BAD_REQUEST);
    }

    public BattcnException(String message, Throwable cause) {
        super(message, cause);
        this.setCustomCode(BAD_REQUEST);
        this.setCode(BAD_REQUEST);
    }

    public BattcnException(int code, String message) {
        super(message);
        this.setCustomCode(code);
        this.setCode(code);
    }

    public BattcnException(int code, int customcode, String message) {
        super(message);
        this.setCustomCode(customcode);
        this.setCode(code);
    }

    public BattcnException(int code, String message, Throwable t) {
        super(message, t);
        this.code = code;
    }

    public ErrorResponseEntity toErrorResponseEntity() {
        return new ErrorResponseEntity(this.customCode, this.getMessage());
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCustomCode() {
        return customCode;
    }

    public void setCustomCode(int customcode) {
        this.customCode = customcode;
    }

}
