package com.services.impl;

import com.dtos.GroupeDto;
import com.entities.Groupe;
import com.repositories.GroupeRepository;
import com.services.GroupeService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("groupeService")
public class GroupeServiceImpl implements GroupeService{

    private final GroupeRepository groupeRepository;

    public GroupeServiceImpl(GroupeRepository groupeRepository) {
        this.groupeRepository = groupeRepository;
    }

    @Override
    public GroupeDto alterGroupe(GroupeDto groupeDto) {
        Groupe alter = groupeDtoToEntity(groupeDto);
        Groupe groupe = groupeRepository.findById(alter.getId()).orElseThrow(() -> new EntityNotFoundException("Groupe not found"));

        groupe.setDescription(alter.getDescription());

        // Save the groupe entity
        groupe = groupeRepository.save(groupe);
        // Return the new dto
        return groupeEntityToDto(groupe);
    }

    @Override
    public GroupeDto saveGroupe(GroupeDto groupeDto) {
        // Converts the dto to the groupe entity
        Groupe groupe = groupeDtoToEntity(groupeDto);
        // Save the groupe entity
        groupe = groupeRepository.save(groupe);
        // Return the new dto
        return groupeEntityToDto(groupe);
    }

    @Override
    public GroupeDto getGroupeById(Long groupeId) {
        Groupe groupe = groupeRepository.findById(groupeId).orElseThrow(() -> new EntityNotFoundException("Groupe not found"));
        return groupeEntityToDto(groupe);
    }

    @Override
    public boolean deleteGroupe(Long groupeId) {
        groupeRepository.deleteById(groupeId);
        return true;
    }

    @Override
    public List<GroupeDto> getAllGroupes() {
        List<GroupeDto> groupeDtos = new ArrayList<>();
        List<Groupe> groupes = groupeRepository.findAll();
        groupes.forEach(groupe -> {
            groupeDtos.add(groupeEntityToDto(groupe));
        });
        return groupeDtos;
    }

    /**
     * Map groupe dto to groupe entity
     */
    private GroupeDto groupeEntityToDto(Groupe groupe){
        GroupeDto groupeDto = new GroupeDto();
        groupeDto.setNom(groupe.getNom());
        groupeDto.setDescription(groupe.getDescription());
        return groupeDto;
    }

    /**
     * Map groupe entity to groupe dto
     */
    private Groupe groupeDtoToEntity(GroupeDto groupeDto){
        Groupe groupe = new Groupe();
        groupe.setNom(groupeDto.getNom());
        groupe.setDescription(groupeDto.getDescription());
        return groupe;
    }
}
