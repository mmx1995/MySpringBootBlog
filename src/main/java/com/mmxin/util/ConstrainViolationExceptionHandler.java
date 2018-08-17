package com.mmxin.util;

import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * 异常信息处理类
 * 主要用来处理Bean 转化过程中出现的异常
 * 比如
 * @author : mmxin
 * @className : ConstrainViolationExceptionHandler
 * @date : 2018/8/17 18:26
 */
public class ConstrainViolationExceptionHandler{
    /*
    * 获取批量异常信息
    * */
    public static String getMessage(ConstraintViolationException e){
        List<String> msgList = new ArrayList<>();
        for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()){
            msgList.add(constraintViolation.getMessage());
        }
        String messages = StringUtils.join(msgList.toArray(),";");
        return messages ;
    }
}
