package com.xxoocode.common.annotation;

import java.lang.annotation.*;


/**
 * 业务日志、异常日志
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SelfMchLog {
    /**
     * 种类模块
     */
    String type() default "";
}
