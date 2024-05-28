package com.poli.songstock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.poli.songstock.business.AdministrationBusiness;
import com.poli.songstock.dto.ApprovalDTO;
import com.poli.songstock.dto.PhysicalOrderDTO;
import com.poli.songstock.dto.SongDTO;

public class AdministrationController {
	
	@Autowired
    private AdministrationBusiness administrationBusiness;

    @PostMapping("/catalogue/songs")
    public ResponseEntity<SongDTO> createSong(@RequestBody SongDTO songDTO) {
		return null;
    	/*return new ResponseEntity<>(administrationBusiness.createSong(songDTO), HttpStatus.CREATED);*/
    }

    @PutMapping("/catalogue/songs/{id}")
    public ResponseEntity<SongDTO> updateSong(@PathVariable Long id, @RequestBody SongDTO songDTO) {
		return null;
        /*return ResponseEntity.ok(administrationBusiness.updateSong(id, songDTO));*/
    }
    
    /*
     * REQUIREMENT 3
     * */

    @PutMapping("/orders/{orderId}/accept")
    public ResponseEntity<PhysicalOrderDTO> acceptOrder(@PathVariable Long orderId, @RequestBody ApprovalDTO approvalDTO) {
		return null;
    	/*return ResponseEntity.ok(administrationBusiness.acceptOrder(orderId, approvalDTO));*/
    }

    @PutMapping("/orders/{orderId}/reject")
    public ResponseEntity<PhysicalOrderDTO> rejectOrder(@PathVariable Long orderId, @RequestBody ApprovalDTO approvalDTO) {
		return null;
    	/*return ResponseEntity.ok(administrationBusiness.rejectOrder(orderId, approvalDTO));*/
    }
    
    /*
     * REQUIREMENT 7, 12
     * 
     * @GetMapping("/reports/sales")
    public List<SalesReportDTO> getSalesReport(@RequestParam String filterType, @RequestParam String filterValue) {
        return administrationService.getSalesReport(filterType, filterValue);
    }*/

}
