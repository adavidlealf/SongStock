package com.poli.songstock.dto;

import java.util.List;
import java.util.Objects;

public class PhysicalOrderDTO {
	
	/**
	 * Basic order data transfer object
	 */
	private BasicOrderDTO basicOrder;

	/**
	 * List of approval data transfer objects
	 */
	private List<ApprovalDTO> approvals;
	

	@Override
	public int hashCode() {
		return Objects.hash(approvals, basicOrder);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhysicalOrderDTO other = (PhysicalOrderDTO) obj;
		return Objects.equals(approvals, other.approvals) && Objects.equals(basicOrder, other.basicOrder);
	}

	/**
	 * Empty Constructor
	 */
	public PhysicalOrderDTO() {
		super();
	}

	/**
	 * @param basicOrder
	 * @param approvals
	 */
	public PhysicalOrderDTO(BasicOrderDTO basicOrder, List<ApprovalDTO> approvals) {
		super();
		this.basicOrder = basicOrder;
		this.approvals = approvals;
	}

	/**
	 * @return the basicOrder
	 */
	public BasicOrderDTO getBasicOrder() {
		return basicOrder;
	}

	/**
	 * @param basicOrder the basicOrder to set
	 */
	public void setBasicOrder(BasicOrderDTO basicOrder) {
		this.basicOrder = basicOrder;
	}

	/**
	 * @return the approvals
	 */
	public List<ApprovalDTO> getApprovals() {
		return approvals;
	}

	/**
	 * @param approvals the approvals to set
	 */
	public void setApprovals(List<ApprovalDTO> approvals) {
		this.approvals = approvals;
	}
	
	
	
}
