package com.niezhiliang.transform.demo.enums;

import com.niezhiliang.transform.demo.common.IDict;

/**
 * @author nzl
 * @version v
 * @date 2023/2/7
 */
public enum ClassLeaderEnum implements IDict<Integer> {
    MONITOR(1, "班长"),
    VICE_MONITOR(2, "副班长"),
    STUDY(3, "学习委员"),
    NORMAL(0, "普通成员");

    ClassLeaderEnum(Integer code, String text) {
        init(code, text);
    }
}
