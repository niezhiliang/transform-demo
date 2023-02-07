package com.niezhiliang.transform.demo.transformer;

import com.niezhiliang.transform.demo.annotation.TransformEnum;
import com.niezhiliang.transform.demo.common.IDict;
import org.springframework.stereotype.Component;


/**
 * 枚举翻译器
 * @author nzl
 * @date 2023/2/7
 */
@Component
public class EnumTransformer<T> implements Transformer<T, TransformEnum> {

    @Override
    @SuppressWarnings("unchecked")
    public String transform(T enumCode,TransformEnum annotation) {
        return IDict.getTextByCode((Class<? extends IDict<T>>) annotation.value(), enumCode);
    }


}
