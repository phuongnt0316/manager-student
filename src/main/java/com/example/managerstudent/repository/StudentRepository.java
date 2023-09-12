package com.example.managerstudent.repository;

import com.example.managerstudent.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    //Viết query theo native
//    @Query(nativeQuery = true,value = "select *from student where first_name = :name")
//    List<Student> filterByName(@Param("name") String name);

    //HQL
    @Query(value = "select s from Student s where s.firstName like concat('%',:name,'%')")
    List<Student> filterByName(@Param("name") String name);

    @Query(value = "select s from Student s where s.adress.city like concat('%',:address,'%')")
    List<Student> filterByAddress(String address);
    //List<Student> findAllByFirstName(String name);
}
