package com.niezhiliang.transform.demo.transformer;


import java.lang.annotation.Annotation;

/**
 * 转换器接口
 * 支持自定义注解
 *
 */
public interface Transformer<T, A extends Annotation> {


    /**
     * 翻译
     *
     * @param originalValue 转换之前的原始值
     * @param annotation    自定义注解
     * @return 翻译后的值
     */
    String transform(T originalValue, A annotation);
}
