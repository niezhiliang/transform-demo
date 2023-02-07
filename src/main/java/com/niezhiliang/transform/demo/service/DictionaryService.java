package com.niezhiliang.transform.demo.service;

import org.springframework.stereotype.Component;

/**
 * @author nzl
 * @version v
 * @date 2023/2/7
 */
@Component
public class DictionaryService {

    public String getText(String dictionaryType, Integer code) {
        if ("sex".equals(dictionaryType)) {
            return 1 == code ? "男" : "女";
        }
        return null;
    }
}
