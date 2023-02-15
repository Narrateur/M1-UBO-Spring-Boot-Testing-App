package com.controllers;

import com.dtos.ArtisteDto;
import org.springframework.web.bind.annotation.*;

import com.services.impl.ArtisteServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/artistes")
public class ArtisteController {

    private final ArtisteServiceImpl artisteService;

    public ArtisteController(ArtisteServiceImpl artisteService) {
        this.artisteService = artisteService;
    }

    /**
     * <p>Get all artistes in the system</p>
     * @return List<ArtisteDto>
     */
    @GetMapping
    public List<ArtisteDto> getArtistes() {
        return artisteService.getAllArtistes();
    }

    /**
     * Method to get the artiste based on the ID
     */
    @GetMapping("/{id}")
    public ArtisteDto getArtiste(@PathVariable Long id){
        return artisteService.getArtisteById(id);
    }

    /**
     * Create a new Artiste in the system
     */
    @PostMapping
    public ArtisteDto saveArtiste(final @RequestBody ArtisteDto artisteDto){
        return artisteService.saveArtiste(artisteDto);
    }

    /**
     * Delete a artiste by it's id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteArtiste(@PathVariable Long id){
        return artisteService.deleteArtiste(id);
    }

    /**
     * Alter a artiste in the system
     */
    @PutMapping
    public  ArtisteDto alterArtiste(final @RequestBody ArtisteDto artisteDto){
        return artisteService.alterArtiste(artisteDto);
    }
}
