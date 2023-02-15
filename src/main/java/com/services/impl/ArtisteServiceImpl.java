package com.services.impl;

import com.dtos.ArtisteDto;
import com.entities.Artiste;
import com.repositories.ArtisteRepository;
import com.services.ArtisteService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("artisteService")
public class ArtisteServiceImpl implements ArtisteService{

    private final ArtisteRepository artisteRepository;

    public ArtisteServiceImpl(ArtisteRepository artisteRepository) {
        this.artisteRepository = artisteRepository;
    }

    @Override
    public ArtisteDto alterArtiste(ArtisteDto artisteDto) {
        Artiste alter = artisteDtoToEntity(artisteDto);
        Artiste artiste = artisteRepository.findById(alter.getId()).orElseThrow(() -> new EntityNotFoundException("Artiste not found"));

        artiste.setDescription(alter.getDescription());

        // Save the artiste entity
        artiste = artisteRepository.save(artiste);
        // Return the new dto
        return artisteEntityToDto(artiste);
    }

    @Override
    public ArtisteDto saveArtiste(ArtisteDto artisteDto) {
        // Converts the dto to the artiste entity
        Artiste artiste = artisteDtoToEntity(artisteDto);
        // Save the artiste entity
        artiste = artisteRepository.save(artiste);
        // Return the new dto
        return artisteEntityToDto(artiste);
    }

    @Override
    public ArtisteDto getArtisteById(Long artisteId) {
        Artiste artiste = artisteRepository.findById(artisteId).orElseThrow(() -> new EntityNotFoundException("Artiste not found"));
        return artisteEntityToDto(artiste);
    }

    @Override
    public boolean deleteArtiste(Long artisteId) {
        artisteRepository.deleteById(artisteId);
        return true;
    }

    @Override
    public List<ArtisteDto> getAllArtistes() {
        List<ArtisteDto> artisteDtos = new ArrayList<>();
        List<Artiste> artistes = artisteRepository.findAll();
        artistes.forEach(artiste -> {
            artisteDtos.add(artisteEntityToDto(artiste));
        });
        return artisteDtos;
    }

    /**
     * Map artiste dto to artiste entity
     */
    private ArtisteDto artisteEntityToDto(Artiste artiste){
        ArtisteDto artisteDto = new ArtisteDto();
        artisteDto.setId(artiste.getId());
        artisteDto.setNom(artiste.getNom());
        artisteDto.setDescription(artiste.getDescription());
        return artisteDto;
    }

    /**
     * Map artiste entity to artiste dto
     */
    private Artiste artisteDtoToEntity(ArtisteDto artisteDto){
        Artiste artiste = new Artiste();
        artiste.setId(artisteDto.getId());
        artiste.setNom(artisteDto.getNom());
        artiste.setDescription(artisteDto.getDescription());
        return artiste;
    }
}
