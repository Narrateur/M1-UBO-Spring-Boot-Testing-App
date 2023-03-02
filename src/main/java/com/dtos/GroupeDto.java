package com.dtos;
import lombok.Data;

import java.util.List;

@Data
public class GroupeDto {

    private Long Id;
    private String nom;
    private String description;
    private List<ArtisteDto> artistes;
}
