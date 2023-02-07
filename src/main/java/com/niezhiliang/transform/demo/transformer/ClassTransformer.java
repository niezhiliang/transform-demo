package com.niezhiliang.transform.demo.transformer;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 自定义翻译器
 * @author nzl
 * @date 2023/2/7
 */
@Service
public class ClassTransformer implements SimpleTransformer<Long>{

    private static ConcurrentMap<Long,String> MAP = new ConcurrentHashMap<>();

    static {
        MAP.put(1L,"会计一班");
        MAP.put(2L,"会计二班");
        MAP.put(3L,"会计三班");
    }

    @Override
    public String transform(Long classId) {

        return MAP.getOrDefault(classId,"未知班级");
    }
}
