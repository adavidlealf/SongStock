package com.poli.songstock.dto;

import java.util.List;
import java.util.Objects;

public class ConsumerDTO {

	private UserRoleDTO userRole;
	
	private	List<ApprovalConsumerDTO> approvals;
	
	private LibraryDTO library;
	
	private	List<DigitalOrderDTO> digitalOrders;
	
	private	List<PhysicalOrderDTO> physicalOrders;
	
	

	@Override
	public int hashCode() {
		return Objects.hash(approvals, digitalOrders, library, physicalOrders, userRole);
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
				&& Objects.equals(library, other.library) && Objects.equals(physicalOrders, other.physicalOrders)
				&& Objects.equals(userRole, other.userRole);
	}

	/**
	 * 
	 */
	public ConsumerDTO() {
		super();
	}

	/**
	 * @param userRole
	 * @param approvals
	 * @param library
	 * @param digitalOrders
	 * @param physicalOrders
	 */
	public ConsumerDTO(UserRoleDTO userRole, List<ApprovalConsumerDTO> approvals, LibraryDTO library,
			List<DigitalOrderDTO> digitalOrders, List<PhysicalOrderDTO> physicalOrders) {
		super();
		this.userRole = userRole;
		this.approvals = approvals;
		this.library = library;
		this.digitalOrders = digitalOrders;
		this.physicalOrders = physicalOrders;
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
	
	
	
}
