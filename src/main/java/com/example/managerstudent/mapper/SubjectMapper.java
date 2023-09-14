package com.example.managerstudent.mapper;

import com.example.managerstudent.DTO.SubjectDto;
import com.example.managerstudent.domain.Subject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class SubjectMapper implements EntityMapper<Subject, SubjectDto> {
    @Override
    public Subject toEntity(SubjectDto subjectDto) {
        return null;
    }

    @Override
    public List<Subject> toEntity(List<SubjectDto> d) {
        return null;
    }

    @Override
    public SubjectDto toDto(Subject subject) {
        SubjectDto dto=new SubjectDto();
        dto.setName(subject.getName());
        return dto;
    }

    @Override
    public List<SubjectDto> toDto(List<Subject> e) {
        List<SubjectDto> dtos=new ArrayList<>();
        e.forEach(subject -> dtos.add(toDto(subject)));
        return  dtos;
    }
}
