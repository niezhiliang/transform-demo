package com.niezhiliang.transform.demo.annotation;

import com.niezhiliang.transform.demo.transformer.Transformer;

import java.lang.annotation.*;

/**
 * 转换注解
 * 可标注在字段上、注解上
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
public @interface Transform {

    /**
     * 指定翻译器
     */
    Class<? extends Transformer> transformer() default Transformer.class;

    /**
     * 来源字段
     * <p>
     * 默认自动推断（推断规则：如注解标注的字段是userName，自动推断结果为“user”，“userId”或“userCode”）
     */
    String from() default "";

    boolean async() default false;

    boolean cache() default false;
}
