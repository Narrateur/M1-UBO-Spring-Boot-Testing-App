package com.services.impl;

import com.dtos.ConcertDto;
import com.repositories.ConcertRepository;
import com.services.ConcertService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("concertService")
public class ConcertServiceImpl implements ConcertService {

    private final ConcertRepository concertRepository;

    public ConcertServiceImpl(ConcertRepository concertRepository){
        this.concertRepository = concertRepository;
    }

    @Override
    public ConcertDto alterConcert(ConcertDto concertDto) {
        Concert alter = concertDtoToEntity(concertDto);
        Concert concert = concertRepository.findById(alter.getId()).orElseThrow(() -> new EntityNotFoundException("Concert not found"));

        concert.setId(concertDto.getId());
        concert.setDate_debut(concertDto.getDate_debut());
        concert.setDate_fin(concertDto.getDate_fin());


        // Save the dog entity
        concert = concertRepository.save(concert);
        // Return the new dto
        return concertEntityToDto(concert);
    }

    @Override
    public ConcertDto saveConcert(ConcertDto concertDto) {
        // Converts the dto to the Concert entity
        Concert concert = concertDtoToEntity(concertDto);
        // Save the Concert entity
        concert = concertRepository.save(concert);
        // Return the new dto
        return concertEntityToDto(concert);
    }

    @Override
    public ConcertDto getConcertById(Long concertId) {
        Concert concert = concertRepository.findById(concertId).orElseThrow(() -> new EntityNotFoundException("Concert not found"));
        return concertEntityToDto(concert);
    }

    @Override
    public boolean deleteConcert(Long concertId) {
        concertRepository.deleteById(concertId);
        return true;
    }

    @Override
    public List<ConcertDto> getAllConcerts() {
        List<ConcertDto> concertDtos = new ArrayList<>();
        List<Concert> concerts = concertRepository.findAll();
        concerts.forEach(concert -> {
            concertDtos.add(concertEntityToDto(concert));
        });
        return concertDtos;
    }

    /**
     * Map Concert dto to Concert entity
     */
    private ConcertDto concertEntityToDto(Concert concert){
        ConcertDto concertDto = new ConcertDto();
        concertDto.setId(concert.getId());
        concertDto.setDate_debut(concert.getDate_debut());
        concertDto.setDate_fin(concert.getDate_fin());
        concertDto.setSalle_id(concert.getSalle().getId());
        concertDto.setPrix(concert.getPrix());
        return concertDto;
    }

    /**
     * Map Concert entity to Concert dto
     */
    private Concert concertDtoToEntity(ConcertDto concertDto){
        Concert concert = new Concert();
        concert.setId(concertDto.getId());
        concert.setDate_debut(concertDto.getDate_debut());
        concert.setDate_fin(concertDto.getDate_fin());

        return concert;
    }
}
