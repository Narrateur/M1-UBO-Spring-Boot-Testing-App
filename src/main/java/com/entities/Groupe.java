package com.entities;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "t_groupe_grp")
public class Groupe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grp_id")
    private Long Id;
    private String nom;
    private String description;

}
