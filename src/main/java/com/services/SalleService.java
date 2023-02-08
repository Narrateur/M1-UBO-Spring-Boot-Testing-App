package com.services;

import com.dtos.SalleDto;

import java.util.List;

public interface SalleService {
    /**
     * Sauve a Salle
     */
    SalleDto alterSalle(SalleDto salleDto);

    /**
     * Sauve a Salle
     */
    SalleDto saveSalle(SalleDto salleDto);

    /**
     * Get a Salle by it's id
     */
    SalleDto getSalleById(Long salleId);

    /**
     * Delete a Salle by it's id
     */
    boolean deleteSalle(Long salleId);

    /**
     * Get all the Salles
     */
    List<SalleDto> getAllSalles();


}
