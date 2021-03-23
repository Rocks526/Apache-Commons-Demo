package com.rocks.commons.lang3.vo;

import java.lang.annotation.*;

/**
 * 自定义注解
 * @author lizhaoxuan
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MyAnnotation {

    String desc() default "这是一个自定义注解";

    String author() default "Rocks526";

    int age() default 22;

}
