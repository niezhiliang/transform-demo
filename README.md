# 字典、枚举翻译功能

## 实现原理
通过自定义注解修饰要翻译的属性，指定翻译器，最后通过AOP拦截返回结果，对结果对象进行
解析，通过对应的翻译器将code翻译成text，最后通过反射将text赋值给对应的属性。

## 自定义注解

- @Transform 需要指定翻译器，通过哪个字段来翻译
```java
/**
 * 拿着classId属性的值，通过翻译器ClassTransformer（自定义翻译器）来翻译
 */
@Transform(from = "classId", transformer = ClassTransformer.class)
private String className;
```
### 衍生注解

- @TransformEnum  修饰枚举属性，指定对应的枚举类，等价于@Transform(from = "xx", transformer = EnumTransformer.class)
```java
/**
 * 指定枚举的翻译对应的枚举类（通过内置的EnumTransformer翻译）
 */
@TransformEnum(ClassLeaderEnum.class)
private String classLeaderName;
```

- @TransformDict 修饰字典属性，指定字典group

```java
/**
 * 性别，字典分组sex
 */
private Integer sex;

/**
 * 指定字典分组sex 通过翻译器DictTransformer（内置翻译器）去翻译
 */
@TransformDict(group = "sex")
private String sexName;
```


### 返回值翻译前
```json
{
    "id":1,
    "name":"张三",
    "classLeader":1,
    "sex":0,
    "classId":2
}
```
### 返回值翻译后
```json
{
    "id": 1,
    "name": "张三",
    "classLeader": 1,
    "classLeaderName": "班长",
    "sex": 0,
    "sexName": "女",
    "classId": 2,
    "className": "会计二班"
}
```

