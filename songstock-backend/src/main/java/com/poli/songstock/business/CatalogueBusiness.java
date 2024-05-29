package com.poli.songstock.business;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poli.songstock.domain.Album;
import com.poli.songstock.domain.AlbumArtist;
import com.poli.songstock.domain.Artist;
import com.poli.songstock.domain.Catalogue;
import com.poli.songstock.domain.Product;
import com.poli.songstock.domain.Song;
import com.poli.songstock.domain.SongArtist;
import com.poli.songstock.domain.Vinyl;
import com.poli.songstock.dto.BasicAlbumDTO;
import com.poli.songstock.dto.BasicArtistDTO;
import com.poli.songstock.dto.CatalogueDTO;
import com.poli.songstock.dto.ProductAlbumDTO;
import com.poli.songstock.dto.ProductSongDTO;
import com.poli.songstock.dto.ProductVinylDTO;
import com.poli.songstock.dto.SongDTO;
import com.poli.songstock.dto.VinylDTO;
import com.poli.songstock.service.AlbumArtistService;
import com.poli.songstock.service.AlbumService;
import com.poli.songstock.service.ArtistService;
import com.poli.songstock.service.CatalogueService;
import com.poli.songstock.service.ProductService;
import com.poli.songstock.service.SongArtistService;
import com.poli.songstock.service.SongService;
import com.poli.songstock.service.VinylService;

@Component
public class CatalogueBusiness {
	
	@Autowired
	private AlbumArtistService albumArtistService;
	
	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private ArtistService artistService;
	
	@Autowired
	private CatalogueService catalogueService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private SongArtistService songArtistService;
	
	@Autowired
	private SongService songService;
	
	@Autowired
	private VinylService vinylService;

	/**
	 * Registra a un artista por su nombre.
	 * @param name String nombre
	 * @return BasicArtistDTO
	 * @throws Exception
	 */
	public BasicArtistDTO registerArtist(String name) throws Exception {
		Artist artist = new Artist();
		if(LogicBusiness.isEmpty(name)) {
			throw new Exception("El nombre del artista no debe ser vacio.");
		}
		artist.setName(name);
		artist = artistService.save(artist);
		if(LogicBusiness.isEmpty(artist) || LogicBusiness.isEmpty(artist.getId())) {
			throw new Exception("No se pudo crear el artista");
		}
		return artistService.getReferenceBasicArtistDtoById(artist.getId());
	}
	
	/**
	 * Crea un album a partir de su nombre, fecha de lanzamiento, url de portada, artistas, distribuidor, precio.
	 * @param name String nombre
	 * @param releaseDate Date fecha de lanzamiento
	 * @param coverUrl String url de la portada
	 * @param artists String nombre de los artistas separados por punto y coma
	 * @param distributorId Long id del distribuidor
	 * @param price Double precio
	 * @return BasicUserDTO instancia del album creado.
	 * @throws Exception En caso de que algun campo no nulo sea vacio, o si no se puede crear/obtener.
	 */
	public BasicAlbumDTO createAlbum(
			String name
			, Date releaseDate
			, String coverUrl
			, String artists
			, Long distributorId
			, Double price
		) throws Exception {
		if(LogicBusiness.isEmpty(distributorId)) {
			throw new Exception("Para crear un album, es necesario su distribuidor");
		}
		if(LogicBusiness.isEmpty(price)) {
			throw new Exception("Para crear un album, es necesario que tenga un precio");
		}
		// Creacion album
		Album album = new Album();
		if(LogicBusiness.isEmpty(name)) {
			throw new Exception("El nombre del album no debe ser vacio.");
		}
		album.setName(name);
		if(LogicBusiness.isEmpty(artists)) {
			throw new Exception("El album debe tener artistas.");
		}
		if(releaseDate != null) {
			album.setReleaseDate(releaseDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		}
		album.setCoverUrl(coverUrl);
		album = albumService.save(album);
		if(LogicBusiness.isEmpty(album) || LogicBusiness.isEmpty(album.getId())) {
			throw new Exception("No se pudo crear el album");
		}
		// Relacion con artistas
		List<String> artistI = LogicBusiness.splitBySemicolon(artists);
		BasicArtistDTO basicArtist;
		for(String sI : artistI) {
			basicArtist = artistService.findBasicArtistByName(sI);
			if(basicArtist == null) {
				basicArtist = registerArtist(sI);
			}
			if(!relateArtistToAlbum(album.getId(), basicArtist.getId())) {
				albumService.deleteById(album.getId());
				throw new Exception("Ocurrio un error relacionando los artistas al album.");
			}
		}
		// Creacion del producto
		Product product = new Product();
		product.setIsDigital(1);
		product.setIsSong(0);
		product.setObjectId(album.getId());
		product.setDistributorId(distributorId);
		product = productService.save(product);
		if(LogicBusiness.isEmpty(product) || LogicBusiness.isEmpty(product.getId())) {
			throw new Exception("No se pudo crear el producto album");
		}
		// Creacion de catalogo
		Catalogue catalogue = new Catalogue();
		catalogue.setProductId(product.getId());
		catalogue.setPrice(price);
		catalogue = catalogueService.save(catalogue);
		if(LogicBusiness.isEmpty(catalogue) || LogicBusiness.isEmpty(catalogue.getId())) {
			throw new Exception("No se pudo crear el catalogo de producto album");
		}
		// Fin
		BasicAlbumDTO rta = albumService.getReferenceBasicAlbumDtoById(album.getId());
		if(LogicBusiness.isEmpty(rta)) {
			throw new Exception("No se pudo obtener el album");
		}
		return rta;
	}
	
	/**
	 * Relaciona un artista con un album mediante sus llaves.
	 * @param albumId Long id del album
	 * @param artistId Long id del artista
	 * @return Boolean true en caso que se haya podido hacer la relacion.
	 * @throws Exception
	 */
	public Boolean relateArtistToAlbum(Long albumId, Long artistId) throws Exception {
		if(artistService.getReferenceById(artistId) == null ) {
			throw new Exception("No se encontro el artista");
		}
		if(albumService.getReferenceById(albumId) == null ) {
			throw new Exception("No se encontro el album");
		}
		AlbumArtist ent = new AlbumArtist();
		ent.setAlbumId(albumId);
		ent.setArtistId(artistId);
		ent = albumArtistService.save(ent);
		if(LogicBusiness.isEmpty(ent) || LogicBusiness.isEmpty(ent.getId())) {
			throw new Exception("No se pudo relacionar el artista al album");
		}
		return true;
	}
	
	/**
	 * Relaciona un artista con una cancion mediante sus llaves.
	 * @param songId Long id de la cancion
	 * @param artistId Long id del artista
	 * @return Boolean true en caso que se haya podido hacer la relacion.
	 * @throws Exception
	 */
	public Boolean relateArtistToSong(Long songId, Long artistId) throws Exception {
		if(artistService.getReferenceById(artistId) == null ) {
			throw new Exception("No se encontro el artista");
		}
		if(songService.getReferenceById(songId) == null ) {
			throw new Exception("No se encontro la cancion");
		}
		SongArtist ent = new SongArtist();
		ent.setSongId(songId);
		ent.setArtistId(artistId);
		ent = songArtistService.save(ent);
		if(LogicBusiness.isEmpty(ent) || LogicBusiness.isEmpty(ent.getId())) {
			throw new Exception("No se pudo relacionar el artista a la cancion");
		}
		return songArtistService.getReferenceById(ent.getId()) != null;
	}
	
	/**
	 * Crea una cancion a partir de si tutilo, duracion, album, artistas, distribuidor, precio.
	 * @param title String titulo
	 * @param duration Integer duracion
	 * @param albumId Long id del album
	 * @param artists String nombre de los artistas separados por punto y coma
	 * @param distributorId Long id del distribuidor de la cancion
	 * @param price Double precio de la cancion
	 * @return SongDTO instancia de la cancion recien creada.
	 * @throws Exception
	 */
	public SongDTO createSong(
			String title
			, Integer duration
			, Long albumId
			, String artists
			, Long distributorId
			, Double price
		) throws Exception {
		if(LogicBusiness.isEmpty(distributorId)) {
			throw new Exception("Para crear una cancion, es necesario su distribuidor");
		}
		if(LogicBusiness.isEmpty(price)) {
			throw new Exception("Para crear una cancion, es necesario que tenga un precio");
		}
		Song song = new Song();
		if(LogicBusiness.isEmpty(title)) {
			throw new Exception("El nombre de la cancion no debe ser vacia.");
		}
		song.setTitle(title);
		if(LogicBusiness.isEmpty(albumId)) {
			throw new Exception("El id del album no debe ser vacio.");
		}
		if(LogicBusiness.isEmpty(artists)) {
			throw new Exception("La cancion debe tener artistas.");
		}
		song.setAlbumId(albumId);
		song.setDuration(duration);
		song = songService.save(song);
		if(LogicBusiness.isEmpty(song) || LogicBusiness.isEmpty(song.getId())) {
			throw new Exception("No se pudo crear la cancion");
		}
		// Relacion con artistas
		List<String> artistI = LogicBusiness.splitBySemicolon(artists);
		BasicArtistDTO basicArtist;
		for(String sI : artistI) {
			basicArtist = artistService.findBasicArtistByName(sI);
			if(basicArtist == null) {
				basicArtist = registerArtist(sI);
			}
			if(!relateArtistToSong(song.getId(), basicArtist.getId())) {
				songService.deleteById(song.getId());
				throw new Exception("Ocurrio un error relacionando los artistas a la cancion.");
			}
		}
		// Creacion del producto
		Product product = new Product();
		product.setIsDigital(1);
		product.setIsSong(1);
		product.setObjectId(song.getId());
		product.setDistributorId(distributorId);
		product = productService.save(product);
		if(LogicBusiness.isEmpty(product) || LogicBusiness.isEmpty(product.getId())) {
			throw new Exception("No se pudo crear el producto cancion");
		}
		// Creacion de catalogo
		Catalogue catalogue = new Catalogue();
		catalogue.setProductId(product.getId());
		catalogue.setPrice(price);
		catalogue = catalogueService.save(catalogue);
		if(LogicBusiness.isEmpty(catalogue) || LogicBusiness.isEmpty(catalogue.getId())) {
			throw new Exception("No se pudo crear el catalogo de producto cancion");
		}
		// Fin
		SongDTO s = songService.getReferenceSongDtoById(song.getId());
		if(LogicBusiness.isEmpty(s) || LogicBusiness.isEmpty(s.getBasicAlbum().getId())) {
			throw new Exception("No se pudo obtener la cancion");
		}
		return s;
	}
	
	/**
	 * Crea un vinilo a partir de sus datos fisicos como el color, las pulgadas, el inventario,
	 * el album al que hace referencia, el distribuidor, el precio.
	 * @param color String color
	 * @param inches Double pulgadas
	 * @param stock Integer inventario
	 * @param album_id Long id del album
	 * @param distributor_id Long id del distribuidor
	 * @param price Double precio
	 * @return VinylDTO dto
	 * @throws Exception
	 */
	public VinylDTO createVinyl(
			String color
			, Double inches
			, Integer stock
			, Long album_id
			, Long distributorId
			, Double price
		) throws Exception {
		if(LogicBusiness.isEmpty(distributorId)) {
			throw new Exception("Para crear un vinilo, es necesario su distribuidor");
		}
		if(LogicBusiness.isEmpty(price)) {
			throw new Exception("Para crear un vinilo, es necesario que tenga un precio");
		}
		// Creacion
		Vinyl ent = new Vinyl();
		ent.setColor(color);
		ent.setInches(inches);
		if(LogicBusiness.isEmpty(stock)) {
			throw new Exception("Inventario invalido");
		}
		ent.setStock(stock);
		if(LogicBusiness.isEmpty(album_id)) {
			throw new Exception("Album del vinilo no puede ser vacio.");
		}
		if(albumService.getReferenceById(album_id) == null) {
			throw new Exception("No existe el album asociado al vinilo.");
		}
		ent.setAlbumId(album_id);
		ent = vinylService.save(ent);
		if(LogicBusiness.isEmpty(ent) || LogicBusiness.isEmpty(ent.getId())) {
			throw new Exception("No se pudo crear el vinilo");
		}
		// Creacion del producto
		Product product = new Product();
		product.setIsDigital(0);
		product.setIsSong(0);
		product.setObjectId(ent.getId());
		product.setDistributorId(distributorId);
		product = productService.save(product);
		if(LogicBusiness.isEmpty(product) || LogicBusiness.isEmpty(product.getId())) {
			throw new Exception("No se pudo crear el producto vinilo");
		}
		// Creacion de catalogo
		Catalogue catalogue = new Catalogue();
		catalogue.setProductId(product.getId());
		catalogue.setPrice(price);
		catalogue = catalogueService.save(catalogue);
		if(LogicBusiness.isEmpty(catalogue) || LogicBusiness.isEmpty(catalogue.getId())) {
			throw new Exception("No se pudo crear el catalogo de producto vinilo");
		}
		// Fin
		return vinylService.getReferenceVinylDtoById(ent.getId());
	}
	
	/**
	 * Obtiene el ProductSongDTO de una cancion por su id.
	 * @param songId Long id de la cancion
	 * @return ProductSongDTO cancion producto.
	 * @throws Exception
	 */
	public ProductSongDTO getProductSongById(Long songId) throws Exception {
		ProductSongDTO dto = songService.getReferenceProductSongDtoById(songId);
		if(LogicBusiness.isEmpty(dto) || LogicBusiness.isEmpty(dto.getPrice())) {
			throw new Exception("No se pudo obtener el producto cancion por id");
		}
		return dto;
	}
	
	/**
	 * Obtiene el ProductAlbumDTO de un album por su id.
	 * @param albumId Long id del album
	 * @return ProductAlbumDTO album producto.
	 * @throws Exception
	 */
	public ProductAlbumDTO getProductAlbumById(Long albumId) throws Exception {
		ProductAlbumDTO dto = albumService.getReferenceProductAlbumDtoById(albumId);
		if(LogicBusiness.isEmpty(dto) || LogicBusiness.isEmpty(dto.getPrice())) {
			throw new Exception("No se pudo obtener el producto album por id");
		}
		return dto;
	}
	
	/**
	 * Obtiene el ProductVinylDTO de un vinilo por su id.
	 * @param viniloId Long id del vinilo
	 * @return ProductVinylDTO vinilo producto.
	 * @throws Exception
	 */
	public ProductVinylDTO getProductVinylById(Long vinylId) throws Exception {
		ProductVinylDTO dto = vinylService.getReferenceProductVinylDtoById(vinylId);
		if(LogicBusiness.isEmpty(dto) || LogicBusiness.isEmpty(dto.getPrice())) {
			throw new Exception("No se pudo obtener el producto vinilo por id");
		}
		return dto;
	}
	
	/**
	 * Obtiene todo el catalogo del sistema
	 * @return
	 */
	public CatalogueDTO getAllCatalogue() {
		return catalogueService.getAllCatalogueDto();
	}
	
	/**
	 * Obtiene todo el catalogo de un distribuidor por su id
	 * @param distributorId Long id del distribuidor
	 * @return CatalogueDTO catalogo del distribuidor
	 */
	public CatalogueDTO getCatalogueByDistributor(Long distributorId) {
		return catalogueService.getCatalogueDtoByDistributor(distributorId);
	}
}
