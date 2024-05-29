package com.poli.songstock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poli.songstock.dto.ProductSongDTO;
import com.poli.songstock.dto.SongDTO;
import com.poli.songstock.dto.ProductVinylDTO;
import com.poli.songstock.dto.VinylDTO;
import com.poli.songstock.requestbody.catalogue.ArtistRequest;
import com.poli.songstock.requestbody.catalogue.ProductAlbumRequest;
import com.poli.songstock.requestbody.catalogue.ProductSongRequest;
import com.poli.songstock.requestbody.catalogue.ProductVinylRequest;
import com.poli.songstock.dto.ProductAlbumDTO;
import com.poli.songstock.dto.BasicAlbumDTO;
import com.poli.songstock.dto.BasicArtistDTO;
import com.poli.songstock.business.CatalogueBusiness;

@RestController
@RequestMapping("/catalogue")
public class CatalogueController {
	
	@Autowired
    private CatalogueBusiness catalogueBusiness;

	/**
	 * Registrar artista por su nombre (debe ser unico).
	 * @param request ArtistRequest estructura de artista
	 * @return BasicArtistDTO artista.
	 */
	@PostMapping(value = "/artist")
	public ResponseEntity<BasicArtistDTO> registerArtist(@RequestBody ArtistRequest request) {
		try {
			BasicArtistDTO b = catalogueBusiness.registerArtist(request.getName());
			return ResponseEntity.ok(b);
		} catch (Exception e) {
			System.out.println("----- Error en /artist");
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PostMapping(value = "/album")
	public ResponseEntity<BasicAlbumDTO> createAlbum(@RequestBody ProductAlbumRequest request) {
		try {
			BasicAlbumDTO a = catalogueBusiness.createAlbum(
					request.getName()
					, request.getReleaseDate()
					, request.getCoverUrl()
					, request.getArtists()
					, request.getDistributorId()
					, request.getPrice()
				);
			return ResponseEntity.ok(a);
		} catch (Exception e) {
			System.out.println("----- Error en /album");
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PostMapping(value = "/song")
	public ResponseEntity<SongDTO> createSong(@RequestBody ProductSongRequest request) {
		try {
			SongDTO s = catalogueBusiness.createSong(
					request.getTitle()
					, request.getDuration()
					, request.getAlbumId()
					, request.getArtists()
					, request.getDistributorId()
					, request.getPrice()
				);
			return ResponseEntity.ok(s);
		} catch (Exception e) {
			System.out.println("----- Error en /song");
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PostMapping(value = "/vinyl")
	public ResponseEntity<VinylDTO> createVinyl(@RequestBody ProductVinylRequest request) {
		try {
			VinylDTO v = catalogueBusiness.createVinyl(
					request.getColor()
					, request.getInches()
					, request.getStock()
					, request.getAlbum_id()
					, request.getDistributorId()
					, request.getPrice()
				);
			return ResponseEntity.ok(v);
		} catch (Exception e) {
			System.out.println("----- Error en /vinyl");
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping(value = "/song/{id}")
	public ResponseEntity<ProductSongDTO> getProductSongById(@PathVariable("id") Long id){
		try {
			ProductSongDTO dto = catalogueBusiness.getProductSongById(id);
			if(dto != null) {
				return ResponseEntity.ok(dto);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			System.out.println("----- Error en /song/{id}");
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping(value = "/album/{id}")
	public ResponseEntity<ProductAlbumDTO> getProductAlbumById(@PathVariable("id") Long id){
		try {
			ProductAlbumDTO dto = catalogueBusiness.getProductAlbumById(id);
			if(dto != null) {
				return ResponseEntity.ok(dto);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			System.out.println("----- Error en /album/{id}");
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping(value = "/vinyl/{id}")
	public ResponseEntity<ProductVinylDTO> getProductVinylById(@PathVariable("id") Long id){
		try {
			ProductVinylDTO dto = catalogueBusiness.getProductVinylById(id);
			if(dto != null) {
				return ResponseEntity.ok(dto);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			System.out.println("----- Error en /vinyl/{id}");
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
