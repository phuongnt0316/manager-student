package com.example.managerstudent.service;

import com.example.managerstudent.DTO.StudentDTO;
import com.example.managerstudent.domain.Student;
import com.example.managerstudent.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.managerstudent.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;
    public List<Student> getAll(){
        List<Student> students=studentRepository.findAll();
        return students;

    }

    public void save(StudentDTO studentDTO) {
        Student student=studentMapper.toEntity(studentDTO);
        studentRepository.save(student);
    }
    public  List<Student> getStudentByName(String name){
        List<Student> lstStudent=studentRepository.findAll();
        List<Student> myList=new ArrayList<>();
        for(Student st:lstStudent){
            if(st.getFirstName().equals(name)){
                myList.add(st);
            }
        }
        return myList;
    }
}
