package com.example.demo01.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class studentcontroller {
    private final studentService studentService;
@Autowired
    public studentcontroller(studentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<student> getStudents(){
        return  studentService.getStudents();

    }
    @PostMapping
    public void registerNewStudent(@RequestBody student student){
    studentService.addNewStudent(student);
    }
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable Long studentId){
    studentService.deleteStudent(studentId);

    }


}
