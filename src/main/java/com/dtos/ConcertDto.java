package com.dtos;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class ConcertDto {

    private Long Id;
    private Date date_debut;
    private Date date_fin;
    private long salle_id;
    private double prix;

}
