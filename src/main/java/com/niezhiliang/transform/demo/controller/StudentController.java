package com.niezhiliang.transform.demo.controller;

import com.fasterxml.jackson.databind.BeanProperty;
import com.niezhiliang.transform.demo.annotation.Transform;
import com.niezhiliang.transform.demo.entity.StudentVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author nzl
 * @version v
 * @date 2023/2/7
 */
@RestController
public class StudentController {

    /**
     * 翻译student
     * @param v
     * @return
     */
    @PostMapping(value = "student")
    @Transform
    public StudentVO getStudent(@RequestBody StudentVO v) {
        StudentVO v1 = new StudentVO();
        v1.setId(2L);
        v1.setName("李四");
        v1.setSex(1);
        v1.setClassId(3L);

        v.setDeskmate(v1);
        v.setTeam(Arrays.asList(v1));

        return v;
    }
}
