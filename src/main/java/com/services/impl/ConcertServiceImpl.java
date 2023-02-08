package com.services.impl;

import com.dtos.ConcertDto;
import com.entities.Concert;
import com.repositories.ConcertRepository;
import com.services.ConcertService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("ConcertService")
public class ConcertServiceImpl implements ConcertService {

    private final ConcertRepository concertRepository;

    public ConcertServiceImpl(ConcertRepository concertRepository){
        this.concertRepository = concertRepository;
    }

    @Override
    public ConcertDto saveConcert(ConcertDto concertDto) {
        // Converts the dto to the Concert entity
        Concert concert = ConcertDtoToEntity(concertDto);
        // Save the Concert entity
        concert = concertRepository.save(concert);
        // Return the new dto
        return ConcertEntityToDto(concert);
    }

    @Override
    public ConcertDto getConcertById(Long concertId) {
        Concert concert = ConcertRepository.findById(concertId).orElseThrow(() -> new EntityNotFoundException("Concert not found"));
        return ConcertEntityToDto(concert);
    }

    @Override
    public boolean deleteConcert(Long concertId) {
        concertRepository.deleteById(concertId);
        return true;
    }

    @Override
    public List<ConcertDto> getAllConcerts() {
        List<ConcertDto> concertDtos = new ArrayList<>();
        List<Concert> concerts = ConcertRepository.findAll();
        Concerts.forEach(Concert -> {
            concertDtos.add(ConcertEntityToDto(Concert));
        });
        return concertDtos;
    }

    /**
     * Map Concert dto to Concert entity
     */
    private ConcertDto ConcertEntityToDto(Concert concert){
        ConcertDto concertDto = new ConcertDto();
        concertDto.setId(concert.getId());

        concertDto.setPrix(concert.getPrix());
        return ConcertDto;
    }

    /**
     * Map Concert entity to Concert dto
     */
    private Concert ConcertDtoToEntity(ConcertDto ConcertDto){
        Concert concert = new Concert();
        concert.setName(ConcertDto.getName());
        concert.setId(ConcertDto.getId());
        concert.setRace(ConcertDto.getRace());
        return concert;
    }
}
