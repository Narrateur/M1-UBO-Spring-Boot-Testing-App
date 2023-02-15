package com.services;

import com.dtos.GroupeDto;
import java.util.List;

public interface GroupeService {
    /**
     * Sauve a dog
     */
    GroupeDto alterGroupe(GroupeDto groupeDto);

    /**
     * Sauve a dog
     */
    GroupeDto saveGroupe(GroupeDto groupeDto);

    /**
     * Get a dog by it's id
     */
    GroupeDto getGroupeById(Long groupeId);

    /**
     * Delete a dog by it's id
     */
    boolean deleteGroupe(Long groupeId);

    /**
     * Get all the dogs
     */
    List<GroupeDto> getAllGroupes();


}
