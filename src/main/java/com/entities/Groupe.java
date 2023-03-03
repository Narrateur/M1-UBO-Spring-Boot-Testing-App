package com.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import com.dtos.ArtisteDto;
import lombok.Data;

@Entity
@Data
@Table(name = "t_groupe_grp")
public class Groupe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grp_id")
    private Long Id;
    @Column(name = "grp_nom")
    private String nom;
    @Column(name = "grp_description")
    private String description;
    @Transient // pour pas le persister dans la bdd
    private List<ArtisteDto> artistes;
}
