package com.niezhiliang.transform.demo.annotation;

import com.niezhiliang.transform.demo.transformer.DictTransformer;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 数据字典转换
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.FIELD})
@Transform(transformer = DictTransformer.class)
public @interface TransformDict {

    /**
     * 默认自动识别形如"...[Id|Code]?"的字段
     * 如翻译后字段为sexName，将扫描sex、sexName、sexCode
     */
    @AliasFor(annotation = Transform.class)
    String from() default "";

    String group();

}
