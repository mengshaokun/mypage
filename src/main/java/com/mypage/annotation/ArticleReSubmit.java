package com.mypage.annotation;

import java.lang.annotation.*;

/**
 * Created by mengsk on 2019/10/14.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ArticleReSubmit {

    String value() default "";
}
