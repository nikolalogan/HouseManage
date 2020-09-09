package com.yuxuanting.housemanage.controller.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 19:51
 */

@RestControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

    @ExceptionHandler(APIException.class)
    public R<String> APIExceptionHandler(APIException e) {
        // 注意哦，这里传递的响应码枚举
        log.error(e.getMessage());
        return new R<>(ResultCode.FAILED, e.getMessage());
    }

//    @ExceptionHandler(Exception.class)
//    public R<String> Exception(Exception e) {
//        log.error(e.getMessage());
//        return new R<>(ResultCode.FAILED, e.getMessage());
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        log.error(e.getMessage());
        return new R<>(ResultCode.VALIDATE_FAILED, objectError.getDefaultMessage());
    }
}