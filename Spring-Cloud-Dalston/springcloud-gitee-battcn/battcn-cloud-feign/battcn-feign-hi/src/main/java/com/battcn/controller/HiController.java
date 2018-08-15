package com.battcn.controller;

import com.battcn.client.HelloClient;
import com.battcn.pojo.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hi")
public class HiController {

    static Logger LOGGER = LoggerFactory.getLogger(HiController.class);

    @Autowired
    HelloClient helloClient;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Student find(@RequestParam("name") String name,@RequestHeader(name="token",required = false)String token) {
        // TODO：只是演示Feign调用的方法
        LOGGER.info("[Token] - [{}]",token);
        return helloClient.findStudentByName(name,token);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Student add(@RequestBody Student student) {
        // TODO：只是演示Feign调用的方法
        return helloClient.addStudent(student);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{studentId}")
    public Student edit(@RequestBody Student student, @PathVariable("studentId") Long studentId) {
        // TODO：只是演示Feign调用的方法
        return helloClient.editStudent(student, studentId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{studentId}")
    public void delete(@PathVariable("studentId") Long studentId) {
        // TODO：只是演示Feign调用的方法
        helloClient.deleteStudent(studentId);
    }

}
