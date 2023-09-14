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
    @Query(nativeQuery = true, value = "select student.* from student,subject,student_subject" +
            "         where student.id=student_subject.id_student" +
            "        and student_subject.id_subject=subject.id" +
            "           and name like CONCAT('%',:subject,'%')")
    List<Student> getStudentBySubject(String subject);

    @Query(nativeQuery = true,value = "select student.* from student,student_subject" +
            "                 where student.id=student_subject.id_student" +
            "           and point >= :point")
    List<Student> getStudentByPoint(int point);
    @Query(nativeQuery = true,value = "select student.* from student,classes " +
            "where student.id_class=classes.id " +
            "and classes.name like concat('%',:classname,'%')")
    List<Student> getStudentByClass(String classname);
    //List<Student> findAllByFirstName(String name);
}
