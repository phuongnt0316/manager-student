package com.example.managerstudent.service;

import com.example.managerstudent.DTO.AdressDTO;
import com.example.managerstudent.DTO.StudentDTO;
import com.example.managerstudent.domain.Adress;
import com.example.managerstudent.domain.Student;
import com.example.managerstudent.mapper.AddressMapper;
import com.example.managerstudent.mapper.StudentMapper;
import com.example.managerstudent.repository.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.managerstudent.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private AdressRepository adressRepository;
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

    public void save(List<StudentDTO> studentDTOS) {
        List<Student> students=studentMapper.toEntity(studentDTOS);
       //students.forEach(student -> studentRepository.save(student));
        studentRepository.saveAll(students);
    }

    public List<StudentDTO> filterByName(String name) {
        List<Student> students=studentRepository.filterByName(name);
        return studentMapper.toDTO(students);
    }

    public List<StudentDTO> filterByAddress(String address) {
        List<Student> students=studentRepository.filterByAddress(address);
        return studentMapper.toDTO(students);
    }

    public List<Adress> getAllAddress() {
        List<Adress> adresses=adressRepository.findAll();
        return adresses;
    }

    public List<AdressDTO> getAddressById(int id) {
        List<Adress> adresses=adressRepository.getAddressById(id);
        return addressMapper.toDto(adresses);
    }
}
