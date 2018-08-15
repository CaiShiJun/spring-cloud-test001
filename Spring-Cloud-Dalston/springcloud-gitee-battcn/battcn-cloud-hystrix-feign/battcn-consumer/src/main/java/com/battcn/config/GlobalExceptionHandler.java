package com.battcn.config;

/**
 * @author Levin
 * @date 2017-08-07.
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.battcn.exception.ErrorResponseEntity;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;

/**
 * ClassName:GrobalExceptionHandler <br/>
 * @author Levin
 * @version 1.0.0
 * @since 2017年07月27日 下午6:36:39
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorResponseEntity jsonErrorHandler(Exception e, HttpServletResponse rep) throws Exception {
        if (e instanceof HystrixBadRequestException) {
            HystrixBadRequestException exception = (HystrixBadRequestException) e;
            rep.setStatus(HttpStatus.BAD_REQUEST.value());
            logger.info("[HystrixBadRequestException] - [" + exception.getMessage() + "]");
            JSONObject obj = JSON.parseObject(exception.getMessage());
            return new ErrorResponseEntity(obj.getInteger("customCode"), obj.getString("message"));
        }
        logger.error("服务器未知异常", e);
        rep.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ErrorResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器未知异常");
    }


    /**
     * 通用的接口映射异常处理方法
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {
        if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) ex;
            return new ResponseEntity<>(exception.getBindingResult().getAllErrors().get(0).getDefaultMessage(), status);
        }
        if (ex instanceof MethodArgumentTypeMismatchException) {
            MethodArgumentTypeMismatchException exception = (MethodArgumentTypeMismatchException) ex;
            logger.error("参数转换失败，方法：" + exception.getParameter().getMethod().getName() + "，参数：" + exception.getName()
                    + ",信息：" + exception.getLocalizedMessage());
            return new ResponseEntity<>("参数转换失败", status);
        }
        return new ResponseEntity<>("参数转换失败", status);
    }
}
