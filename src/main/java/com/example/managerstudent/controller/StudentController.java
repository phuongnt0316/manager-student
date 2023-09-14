package com.example.managerstudent.controller;

import com.example.managerstudent.DTO.AdressDTO;
import com.example.managerstudent.DTO.StudentDTO;
import com.example.managerstudent.domain.Adress;
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
    @PostMapping("/students1")
    String save(@RequestBody List<StudentDTO> studentDTOS){
        studentService.save(studentDTOS);
        return "OK";
    }
    @GetMapping("/filter-name")
    List<StudentDTO> filterByName(@RequestParam("name") String name){
        List<StudentDTO> dtos=studentService.filterByName(name);
        return dtos;

    }
    @GetMapping("/filter-address")
    List<StudentDTO> filterByAddress(@RequestParam("address") String address){
        List<StudentDTO> dtos=studentService.filterByAddress(address);
        return dtos;

    }
    @GetMapping("/getAllAddress")
    List<Adress> getAllAddress() {
        List<Adress> dtos = studentService.getAllAddress();
        return dtos;
    }
    @GetMapping("/getAddressById")
    List<AdressDTO> getAddressById(@RequestParam("id") int id) {
        List<AdressDTO> dtos = studentService.getAddressById(id);
        return dtos;
    }
    @GetMapping("/getStudentBySubject")
    List<StudentDTO> getStudentBySubject(@RequestParam("subject") String subject) {
        List<StudentDTO> dtos = studentService.getStudentBySubject(subject);
        return dtos;
    }
    @GetMapping("/getStudentByPoint")
    List<StudentDTO> getStudentByPoint(@RequestParam("point") int point) {
        List<StudentDTO> dtos = studentService.getStudentByPoint(point);
        return dtos;
    }
    @GetMapping("/getStudentByClass")
    List<StudentDTO> getStudentByClass(@RequestParam("classname") String classname) {
        List<StudentDTO> dtos = studentService.getStudentByClass(classname);
        return dtos;
    }
}
