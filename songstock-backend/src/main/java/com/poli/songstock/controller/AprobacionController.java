package com.poli.songstock.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poli.songstock.business.ProductoReproducibleBusiness;
import com.poli.songstock.domain.AprobacionDTO;
import com.poli.songstock.service.AprobacionService;

@RestController
@RequestMapping("/aprobacion")
public class AprobacionController {

	private static AprobacionController instance;
	
	public static AprobacionController getInstace() {
		if(instance==null) {
			instance = new AprobacionController();
		}
		return instance;
	}
	
	@Autowired
	private AprobacionService controller;
	
	@GetMapping
	public ResponseEntity<List<AprobacionDTO>> findAllAprobacion() {
	    List<AprobacionDTO> aprobaciones = controller.findAll();
	    if (aprobaciones.isEmpty()) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.ok(aprobaciones);
	    }
	}
	
	@GetMapping(value = "/codigo/{codigo}")
	public ResponseEntity<AprobacionDTO> findByCodigoAprobacion(@PathVariable("codigo") String codigo) {
	    Optional<AprobacionDTO> aprobacion = controller.findByCodigo(codigo);
	    if (aprobacion.isPresent()) {
	        return ResponseEntity.ok(aprobacion.get());
	    } else {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	    }
	}
	
	@PostMapping
	public ResponseEntity<AprobacionDTO> saveAprobacion(@RequestBody AprobacionDTO aprobacion){
		try {
			AprobacionDTO aproRet = controller.save(aprobacion);
			return ResponseEntity.created(new URI("/aprobacion/"+aproRet.getId())).body(aproRet);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping(value = "/delete/{codigo}")
	public ResponseEntity<Boolean> deleteByCodigoAprobacion(@PathVariable("codigo") String codigo) {
	    controller.deleteByCodigo(codigo);
        return ResponseEntity.ok(!controller.existsByCodigo(codigo));
	}
}
