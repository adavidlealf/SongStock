package com.poli.songstock.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poli.songstock.controller.AprobacionController;
import com.poli.songstock.model.AprobacionDTO;

@RestController
@RequestMapping("/aprobacion/")
public class AprobacionREST {

	@Autowired
	private AprobacionController controller;
	
	@GetMapping
	private ResponseEntity<List<AprobacionDTO>> findAllAprobacion(){
		return ResponseEntity.ok(controller.findAll());
	}
	
	@PostMapping
	private ResponseEntity<AprobacionDTO> saveAprobacion(@RequestBody AprobacionDTO aprobacion){
		try {
			AprobacionDTO aproRet = controller.save(aprobacion);
			return ResponseEntity.created(new URI("/aprobacion/"+aproRet.getId())).body(aproRet);
		} catch (Exception e) {
			return ResponseEntity.status(400).build();
		}
	}
}
