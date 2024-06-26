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
import com.poli.songstock.dto.ProductCatalogueDTO;
import com.poli.songstock.dto.BasicAlbumDTO;
import com.poli.songstock.dto.BasicArtistDTO;
import com.poli.songstock.dto.CatalogueDTO;
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
	
	/**
	 * Crea un album a partir de su nombre, fecha de lanzamiento, url de portada, artistas, distribuidor, precio.
	 * @param request ProductAlbumRequest estructura JSON de los campos necesarios para album.
	 * @return BasicAlbumDTO instancia creada.
	 */
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
	
	/**
	 * Crea una cancion a partir de si tutilo, duracion, album, artistas, distribuidor, precio.
	 * @param request ProductSongRequest estructura JSON con campos necesarios para cancion.
	 * @return SongDTO instancia de la cancion recien creada.
	 */
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
	
	/**
	 * Crea un vinilo a partir de sus datos fisicos como el color, las pulgadas, el inventario,
	 * el album al que hace referencia, el distribuidor, el precio.
	 * @param request ProductVinylRequest estructura JSON con campos necesarios de vinilo.
	 * @return VinylDTO dto instanciado
	 */
	@PostMapping(value = "/vinyl")
	public ResponseEntity<VinylDTO> createVinyl(@RequestBody ProductVinylRequest request) {
		try {
			VinylDTO v = catalogueBusiness.createVinyl(
					request.getColor()
					, request.getInches()
					, request.getStock()
					, request.getAlbumId()
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
	
	/**
	 * Obtiene una cancion por id en tipo ProductSongDTO
	 * @param id Long id de la cancion
	 * @return ProductSongDTO cancion buscada
	 */
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
	
	/**
	 * Obtiene un album por id en tipo ProductAlbumDTO
	 * @param id Long id del album
	 * @return ProductAlbumDTO album buscado
	 */
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
	
	/**
	 * Obtiene un vinilo por id en tipo ProductVinylDTO
	 * @param id Long id del vinilo
	 * @return ProductVinylDTO vinilo buscado
	 */
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
	
	/**
	 * Obtiene el catalogo de todo el sistema en el que canciones, albumes, 
	 * y vinilos se representan con su DTO Product.
	 * @return ProductCatalogueDTO catalogo de productos.
	 */
	@GetMapping(value = "/products")
	public ResponseEntity<ProductCatalogueDTO> getAllProductCatalogue(){
		try {
			ProductCatalogueDTO dto = catalogueBusiness.getAllProductCatalogue();
			if(dto != null) {
				return ResponseEntity.ok(dto);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			System.out.println("----- Error en /catalogue/products");
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	/**
	 * Obtiene el catalogo de todo el sistema en el que canciones, albumes, 
	 * y vinilos se representan con su DTO normal.
	 * @return CatalogueDTO catalogo de articulos.
	 */
	@GetMapping
	public ResponseEntity<CatalogueDTO> getAllCatalogue(){
		try {
			CatalogueDTO dto = catalogueBusiness.getAllCatalogue();
			if(dto != null) {
				return ResponseEntity.ok(dto);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			System.out.println("----- Error en /catalogue");
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	/**
	 * Obtiene el catalogo que ofrece un distribuidor en el que canciones, albumes, 
	 * y vinilos se representan con su DTO Product.
	 * @return ProductCatalogueDTO catalogo de productos de un distribuidor.
	 */
	@GetMapping("/distributor/{id}")
	public ResponseEntity<ProductCatalogueDTO> getProductCatalogueByDistributor(@PathVariable("id") Long id){
		try {
			ProductCatalogueDTO dto = catalogueBusiness.getProductCatalogueByDistributor(id);
			if(dto != null) {
				return ResponseEntity.ok(dto);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			System.out.println("----- Error en /catalogue/distributor");
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
