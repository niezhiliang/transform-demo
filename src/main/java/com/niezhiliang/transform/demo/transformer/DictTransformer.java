package com.niezhiliang.transform.demo.transformer;

import com.niezhiliang.transform.demo.annotation.TransformDict;
import com.niezhiliang.transform.demo.service.DictionaryService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * 字典翻译器
 * @author nzl
 * @date 2023/2/7
 */
@Component
public class DictTransformer implements Transformer<Integer, TransformDict>{

    /**
     * 字典服务
     */
    @Resource
    private DictionaryService dictionaryService;

    @Override
    public String transform(Integer code, TransformDict transformDict) {
        String text = dictionaryService.getText(transformDict.group(), code);
        return Optional.ofNullable(text).orElse("");
    }
}
