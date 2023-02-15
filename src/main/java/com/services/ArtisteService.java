package com.services;

import com.dtos.ArtisteDto;
import java.util.List;

public interface ArtisteService {
    /**
     * Sauve a dog
     */
    ArtisteDto alterArtiste(ArtisteDto artisteDto);

    /**
     * Sauve a dog
     */
    ArtisteDto saveArtiste(ArtisteDto artisteDto);

    /**
     * Get a dog by it's id
     */
    ArtisteDto getArtisteById(Long artisteId);

    /**
     * Delete a dog by it's id
     */
    boolean deleteArtiste(Long artisteId);

    /**
     * Get all the dogs
     */
    List<ArtisteDto> getAllArtistes();


}
