package com.niezhiliang.transform.demo.transformer;

import com.niezhiliang.transform.demo.annotation.Transform;


/**
 * 建议转换器接口
 *
 */
public interface SimpleTransformer<T> extends Transformer<T, Transform> {
    @Override
    default String transform(T originalValue, Transform transform) {
        return transform(originalValue);
    }

    /**
     * 翻译
     *
     * @param originalValue 原始值
     * @return 翻译后的值
     */
    String transform(T originalValue);


}
