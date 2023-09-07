package com.example.managerstudent.controller;

import com.example.managerstudent.DTO.StudentDTO;
import com.example.managerstudent.domain.Student;
import com.example.managerstudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/students")
    List<Student> getAll(){
        return studentService.getAll();
    }
    @PostMapping ("/student")
    String save(@RequestBody StudentDTO studentDTO){
        studentService.save(studentDTO);
        return "Save";
    }

    @PostMapping("/studentByName")
    List<Student>getStudentByName(@RequestParam("name") String name){
        return studentService.getStudentByName(name);

    }
}
