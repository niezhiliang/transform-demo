package com.niezhiliang.transform.demo.aspect;

import com.niezhiliang.transform.demo.utils.TransformUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 转换器AOP
 *
 */
@Aspect
@Component
@Order(2)
@Slf4j
public class TransformAspect {

    @Resource
    private GenericConversionService genericConversionService;

    @AfterReturning(pointcut = "@annotation(com.niezhiliang.transform.demo.annotation.Transform)", returning = "returnValue")
    public void doAfter(Object returnValue) {
        // 获取容器中的转换器进行返回值解包，注意此处返回结果可能是Bean也可能是集合
        Object result = genericConversionService.convert(returnValue, Object.class);

        TransformUtil.transform(result);
    }
}
