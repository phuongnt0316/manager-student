package com.example.managerstudent.repository;

import com.example.managerstudent.DTO.AdressDTO;
import com.example.managerstudent.domain.Adress;
import com.example.managerstudent.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdressRepository extends JpaRepository<Adress, Integer> {
    @Query(value = "select s from Adress s where s.id = :id")
    List<Adress> getAddressById(@Param("id") int id);
}
