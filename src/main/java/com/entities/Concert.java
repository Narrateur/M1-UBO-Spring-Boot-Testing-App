package com.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Concert {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Date date_debut;
    private Date date_fin;
    @ManyToOne
    private Salle salle;
    @ManyToMany
    private List<Groupe> artistes;
    private double prix;

}
