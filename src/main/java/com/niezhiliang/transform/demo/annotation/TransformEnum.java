package com.niezhiliang.transform.demo.annotation;

import com.niezhiliang.transform.demo.common.IDict;
import com.niezhiliang.transform.demo.transformer.EnumTransformer;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.FIELD})
@Transform(transformer = EnumTransformer.class)
public @interface TransformEnum {

    @AliasFor(annotation = Transform.class)
    String from() default "";

    Class<? extends IDict<?>> value();

}
