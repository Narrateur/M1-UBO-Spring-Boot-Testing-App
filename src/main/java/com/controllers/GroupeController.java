package com.controllers;

import com.dtos.GroupeDto;
import org.springframework.web.bind.annotation.*;

import com.services.impl.GroupeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/groupes")
public class GroupeController {

    private final GroupeServiceImpl groupeService;

    public GroupeController(GroupeServiceImpl groupeService) {
        this.groupeService = groupeService;
    }

    /**
     * <p>Get all groupes in the system</p>
     * @return List<GroupeDto>
     */
    @GetMapping
    public List<GroupeDto> getGroupes() {
        return groupeService.getAllGroupes();
    }

    /**
     * Method to get the groupe based on the ID
     */
    @GetMapping("/{id}")
    public GroupeDto getGroupe(@PathVariable Long id){
        return groupeService.getGroupeById(id);
    }

    /**
     * Create a new Groupe in the system
     */
    @PostMapping
    public GroupeDto saveGroupe(final @RequestBody GroupeDto groupeDto){
        return groupeService.saveGroupe(groupeDto);
    }

    /**
     * Delete a groupe by it's id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteGroupe(@PathVariable Long id){
        return groupeService.deleteGroupe(id);
    }

    /**
     * Alter a groupe in the system
     */
    @PutMapping
    public  GroupeDto alterGroupe(final @RequestBody GroupeDto groupeDto){
        return groupeService.alterGroupe(groupeDto);
    }
}
