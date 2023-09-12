package com.example.managerstudent.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdressDTO {
    Integer id;
    String name;
    String city;
    String district;
}