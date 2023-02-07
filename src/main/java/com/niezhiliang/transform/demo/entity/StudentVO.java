package com.niezhiliang.transform.demo.entity;

import com.niezhiliang.transform.demo.annotation.Transform;
import com.niezhiliang.transform.demo.annotation.TransformDict;
import com.niezhiliang.transform.demo.annotation.TransformEnum;
import com.niezhiliang.transform.demo.enums.ClassLeaderEnum;
import com.niezhiliang.transform.demo.transformer.ClassTransformer;
import com.niezhiliang.transform.demo.transformer.DictTransformer;
import lombok.Data;

import java.util.List;


@Data
@SuppressWarnings("all")
public class StudentVO {
    private Long id;
    /**
     * 名字
     */
    private String name;

    /**
     * 班干部-枚举（1-班长，2-副班长，3-学习委员，0-普通成员）
     */
    private Integer classLeader;

    /**
     * 指定枚举的翻译器
     */
    @TransformEnum(ClassLeaderEnum.class)
    private String classLeaderName;

    /**
     * 性别，字典分组sex
     */
    private Integer sex;

    /**
     * 指定字典分组sex 通过翻译器DictTransformer去翻译
     */
    @TransformDict(group = "sex")
    private String sexName;

    /**
     * 班级-需通过班级信息进行转换（class表根据id查询name）
     */
    private Long classId;
    /**
     * 拿着classId属性的值，通过翻译器ClassTransformer来翻译
     */
    @Transform(from = "classId", transformer = ClassTransformer.class)
    private String className;

    /**
     * 测试集合翻译
     */
    @Transform(from = "sex",transformer = DictTransformer.class)
    private List<StudentVO> team;

    /**
     * 测试属性嵌套翻译
     */
    @Transform
    private StudentVO deskmate;
}
