package com.poli.songstock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poli.songstock.dto.CatalogueDTO;
import com.poli.songstock.dto.ProductSongDTO;
import com.poli.songstock.dto.SongDTO;
import com.poli.songstock.dto.ProductVinylDTO;
import com.poli.songstock.dto.VinylDTO;
import com.poli.songstock.dto.ProductAlbumDTO;
import com.poli.songstock.dto.AlbumDTO;
import com.poli.songstock.business.CatalogueBusiness;

@RestController
@RequestMapping("/catalogue")
public class CatalogueController {
	
	/*
	 * REQUIREMENTS 4, 5, 9
	 * */
	
	@Autowired
    private CatalogueBusiness catalogueBusiness;

    @GetMapping
    public CatalogueDTO getCatalogue() {
        return catalogueBusiness.getCatalogue();
    }

    @GetMapping("/songs")
    public List<ProductSongDTO> getAllSongs() {
        return catalogueBusiness.getAllSongs();
    }

    @GetMapping("/songs/{id}")
    public SongDTO getSongById(@PathVariable Long id) {
        return catalogueBusiness.getSongById(id);
    }
    
    @PutMapping("/songs/{id}")
    public ResponseEntity<VinylDTO> updateSongs(@PathVariable Long id, @RequestBody SongDTO songDTO) {
		return null;
    	/*return ResponseEntity.ok(catalogueBusiness.updateSong(id, songDTO));*/
	}

    @GetMapping("/vinyls")
    public List<ProductVinylDTO> getAllVinyls() {
        return catalogueBusiness.getAllVinyls();
    }

    @GetMapping("/vinyls/{id}")
    public VinylDTO getVinylById(@PathVariable Long id) {
        return catalogueBusiness.getVinylById(id);
    }

    @GetMapping("/albums")
    public List<ProductAlbumDTO> getAllAlbums() {
        return catalogueBusiness.getAllAlbums();
    }

    @GetMapping("/albums/{id}")
    public AlbumDTO getAlbumById(@PathVariable Long id) {
        return catalogueBusiness.getAlbumById(id);
    }

    @PostMapping("/vinyls")
    public ResponseEntity<VinylDTO> createVinyl(@RequestBody VinylDTO vinylDTO) {
		return null;
    	/*return new ResponseEntity<>(catalogueBusiness.createVinyl(vinylDTO), HttpStatus.CREATED);*/
    }

    @PutMapping("/vinyls/{id}")
    public ResponseEntity<VinylDTO> updateVinyl(@PathVariable Long id, @RequestBody VinylDTO vinylDTO) {
		return null;
    	/*return ResponseEntity.ok(catalogueBusiness.updateVinyl(id, vinylDTO));*/
    }

}
