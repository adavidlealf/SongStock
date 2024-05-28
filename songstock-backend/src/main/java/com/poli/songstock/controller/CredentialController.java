package com.poli.songstock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.poli.songstock.business.CredentialsBusiness;
import com.poli.songstock.dto.DistributorDTO;
import com.poli.songstock.dto.UserDTO;

public class CredentialController {
	
	@Autowired
    private CredentialsBusiness credentialsBusiness;
	
	/*
	 * REQUIREMENT 1
	 * */

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
		return null;
    	/*return new ResponseEntity<>(credentialsBusiness.registerUser(userDTO), HttpStatus.CREATED);*/
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> loginUser(@RequestBody LoginRequest loginRequest) {
    	/*return ResponseEntity.ok(credentialsBusiness.loginUser(loginRequest));*/
    }
    
    
    /*
     * REQUIREMENT 8
     * 
     * @PostMapping("/registerProvider")
    public ResponseEntity<DistributorDTO> registerProvider(@RequestBody DistributorDTO distributorDTO) {
        return new ResponseEntity<>(credentialsBusiness.registerProvider(distributorDTO), HttpStatus.CREATED);
    }
     */
    

}
