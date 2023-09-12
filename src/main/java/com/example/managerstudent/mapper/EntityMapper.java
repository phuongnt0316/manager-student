package com.example.managerstudent.mapper;

import java.util.List;

public interface EntityMapper <E, D>{
    public E toEntity(D d);
    public List<E> toEntity(List<D> d);
    D toDto(E e);
    List<D> toDto(List<E> e);
}
