package com.entities;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "t_Artiste_art")
public class Artiste {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "art_id")
    private Long Id;
    @Column(name = "art_nom")
    private String nom;
    @Column(name = "art_prenom")
    private String prenom;
    @Column(name = "art_pseudo")
    private String pseudo;
    @Column(name = "art_ville")
    private String ville;
    @Column(name = "art_age")
    private int age;

    // a voir
    @Column(name = "grp_id")
    private int groupe;


}
