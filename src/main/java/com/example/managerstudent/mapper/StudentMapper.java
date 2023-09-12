package com.example.managerstudent.mapper;

import com.example.managerstudent.DTO.StudentDTO;
import com.example.managerstudent.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class StudentMapper {
    @Autowired
    private  AddressMapper addressMapper;
    public StudentDTO toDTO(Student entity){
        StudentDTO st= StudentDTO
                .builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .adressDTO(addressMapper.toDto(entity.getAdress()))
                .build();
        return st;
    }
    public List<StudentDTO> toDTO(List<Student> entities){
        List<StudentDTO> dtos=new ArrayList<>();
        entities.forEach(student ->{
            StudentDTO dto=toDTO(student);
            dtos.add(dto);
        });
        return dtos;
    }
    public Student toEntity(StudentDTO dto){
        Student student=Student
                .builder()
                //.id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .build();
        return student;
    }
    public List<Student> toEntity(List<StudentDTO> dtos){
        List<Student> students=new ArrayList<>();
        dtos.forEach(dto->{
            students.add(toEntity(dto));
        });
        return students;
    }

}
