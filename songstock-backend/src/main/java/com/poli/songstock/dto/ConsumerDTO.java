package com.poli.songstock.dto;

import java.util.List;
import java.util.Objects;

import com.poli.songstock.domain.ShoppingKart;

public class ConsumerDTO {

	/**
	 * User role data transfer object
	 */
	private UserRoleDTO userRole;

	/**
	 * List of approval consumer data transfer objects
	 */
	private List<ApprovalConsumerDTO> approvals;

	/**
	 * Library data transfer object
	 */
	private LibraryDTO library;

	/**
	 * List of digital order data transfer objects
	 */
	private List<DigitalOrderDTO> digitalOrders;

	/**
	 * List of physical order data transfer objects
	 */
	private List<PhysicalOrderDTO> physicalOrders;
	
	/**
	 * Collection of products to buy later
	 */
	private ShoppingKartDTO kart;

	@Override
	public int hashCode() {
		return Objects.hash(approvals, digitalOrders, kart, library, physicalOrders, userRole);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsumerDTO other = (ConsumerDTO) obj;
		return Objects.equals(approvals, other.approvals) && Objects.equals(digitalOrders, other.digitalOrders)
				&& Objects.equals(kart, other.kart) && Objects.equals(library, other.library)
				&& Objects.equals(physicalOrders, other.physicalOrders) && Objects.equals(userRole, other.userRole);
	}

	/**
	 * @return the userRole
	 */
	public UserRoleDTO getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(UserRoleDTO userRole) {
		this.userRole = userRole;
	}

	/**
	 * @return the approvals
	 */
	public List<ApprovalConsumerDTO> getApprovals() {
		return approvals;
	}

	/**
	 * @param approvals the approvals to set
	 */
	public void setApprovals(List<ApprovalConsumerDTO> approvals) {
		this.approvals = approvals;
	}

	/**
	 * @return the library
	 */
	public LibraryDTO getLibrary() {
		return library;
	}

	/**
	 * @param library the library to set
	 */
	public void setLibrary(LibraryDTO library) {
		this.library = library;
	}

	/**
	 * @return the digitalOrders
	 */
	public List<DigitalOrderDTO> getDigitalOrders() {
		return digitalOrders;
	}

	/**
	 * @param digitalOrders the digitalOrders to set
	 */
	public void setDigitalOrders(List<DigitalOrderDTO> digitalOrders) {
		this.digitalOrders = digitalOrders;
	}

	/**
	 * @return the physicalOrders
	 */
	public List<PhysicalOrderDTO> getPhysicalOrders() {
		return physicalOrders;
	}

	/**
	 * @param physicalOrders the physicalOrders to set
	 */
	public void setPhysicalOrders(List<PhysicalOrderDTO> physicalOrders) {
		this.physicalOrders = physicalOrders;
	}

	/**
	 * @return the kart
	 */
	public ShoppingKartDTO getKart() {
		return kart;
	}

	/**
	 * @param kart the kart to set
	 */
	public void setKart(ShoppingKartDTO kart) {
		this.kart = kart;
	}

	/**
	 * @param userRole
	 * @param approvals
	 * @param library
	 * @param digitalOrders
	 * @param physicalOrders
	 * @param kart
	 */
	public ConsumerDTO(UserRoleDTO userRole, List<ApprovalConsumerDTO> approvals, LibraryDTO library,
			List<DigitalOrderDTO> digitalOrders, List<PhysicalOrderDTO> physicalOrders, ShoppingKartDTO kart) {
		this.userRole = userRole;
		this.approvals = approvals;
		this.library = library;
		this.digitalOrders = digitalOrders;
		this.physicalOrders = physicalOrders;
		this.kart = kart;
	}

	/**
	 * Empty constructor
	 */
	public ConsumerDTO() {
	}

}
