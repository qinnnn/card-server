/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.xxoocode.common.annotation;

import java.lang.annotation.*;

/**
 * 系统日志注解
 *
 * @author Mark sunlightcs@gmail.com
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DeptFilter {

    /**
     * 是否需要角色数据域
     */
    boolean role() default false;

    /**
     * 是否需要用户数据域
     */
    boolean user() default true;

    /**
     * 是否需要部门数据域
     */
    boolean dpet() default true;
}
