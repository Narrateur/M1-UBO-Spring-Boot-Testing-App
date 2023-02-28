package com.dtos;
import lombok.Data;

@Data
public class ArtisteDto {

    private Long Id;
    private String nom;
    private String prenom;
    private String pseudo;
    private String ville;
    private int age;
    private int groupe;
}
