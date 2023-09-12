package com.example.managerstudent.mapper;

import com.example.managerstudent.DTO.AdressDTO;
import com.example.managerstudent.DTO.StudentDTO;
import com.example.managerstudent.domain.Adress;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class AddressMapper implements EntityMapper<Adress, AdressDTO>{
    @Override
    public Adress toEntity(AdressDTO adressDTO) {
        return null;
    }

    @Override
    public List<Adress> toEntity(List<AdressDTO> d) {
        return null;
    }

    @Override
    public AdressDTO toDto(Adress adress) {
        return AdressDTO
                .builder()
                .city(adress.getCity())
                .district(adress.getDistrict())
                .name(adress.getName())
                .build();
    }

    @Override
    public List<AdressDTO> toDto(List<Adress> entities) {
        List<AdressDTO> dtos=new ArrayList<>();
        entities.forEach(address ->{
            AdressDTO dto=toDto(address);
            dtos.add(dto);
        });
        return dtos;
    }
}
