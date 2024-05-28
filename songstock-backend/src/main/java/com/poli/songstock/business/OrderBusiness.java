package com.poli.songstock.business;

import com.poli.songstock.dto.LibraryDTO;
import com.poli.songstock.dto.DigitalOrderDTO;
import com.poli.songstock.dto.PhysicalOrderDTO;

public class OrderBusiness {
	
	/*
	 * REQUIREMENT 6, 2
	 * */

	public Object addToCart(DigitalOrderDTO digitalOrderDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public LibraryDTO getCart(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object checkoutDigital(DigitalOrderDTO digitalOrderDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * REQUIREMENT 11
	 * */

	public Object confirmShipment(Long orderId, PhysicalOrderDTO physicalOrderDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object checkoutPhysical(PhysicalOrderDTO physicalOrderDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
     * REQUIREMENT 10, 12
     * 
     * */

	public Object getAllCheckout(PhysicalOrderDTO physicalOrderDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
