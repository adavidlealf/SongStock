package com.poli.songstock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.poli.songstock.business.OrderBusiness;
import com.poli.songstock.dto.DigitalOrderDTO;
import com.poli.songstock.dto.LibraryDTO;
import com.poli.songstock.dto.PhysicalOrderDTO;

public class OrderController {
	
	@Autowired
    private OrderBusiness orderBusiness;

	/*
	 * REQUIREMENT 6, 2
	 * */
	
    @GetMapping("/cart")
    public LibraryDTO getCart(@RequestParam Long userId) {
        return orderBusiness.getCart(userId);
    }

    @PostMapping("/cart")
    public ResponseEntity<LibraryDTO> addToCart(@RequestBody DigitalOrderDTO digitalOrderDTO) {
        return new ResponseEntity<>(orderBusiness.addToCart(digitalOrderDTO), HttpStatus.CREATED);
    }

    @PostMapping("/checkout/digital")
    public ResponseEntity<DigitalOrderDTO> checkoutDigital(@RequestBody DigitalOrderDTO digitalOrderDTO) {
        return new ResponseEntity<>(orderBusiness.checkoutDigital(digitalOrderDTO), HttpStatus.CREATED);
    }

    @PostMapping("/checkout/physical")
    public ResponseEntity<PhysicalOrderDTO> checkoutPhysical(@RequestBody PhysicalOrderDTO physicalOrderDTO) {
        return new ResponseEntity<>(orderBusiness.checkoutPhysical(physicalOrderDTO), HttpStatus.CREATED);
    }
    
    /*
     * REQUIREMENT 10, 12
     * 
     * */
    
    @PostMapping("/checkout/{id}")
    public ResponseEntity<PhysicalOrderDTO> getAllCheckout(@RequestBody PhysicalOrderDTO physicalOrderDTO) {
        return new ResponseEntity<>(orderBusiness.getAllCheckout(physicalOrderDTO), HttpStatus.CREATED);
    }
    
    /*
	 * REQUIREMENT 11
	 * */

    @PutMapping("/confirmShipment/{orderId}")
    public ResponseEntity<PhysicalOrderDTO> confirmShipment(@PathVariable Long orderId, @RequestBody PhysicalOrderDTO physicalOrderDTO) {
		return null;
        /*return ResponseEntity.ok(orderBusiness.confirmShipment(orderId, physicalOrderDTO));*/
    }

}
