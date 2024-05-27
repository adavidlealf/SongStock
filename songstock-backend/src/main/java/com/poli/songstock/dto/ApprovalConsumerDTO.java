package com.poli.songstock.dto;

import java.util.Objects;

public class ApprovalConsumerDTO {
	
	/**
	 * Data from DTO Approval as approval
	 */
	private ApprovalDTO approval;
	
	/**
	 * Data from DTO BasicUser as approver
	 */
	private BasicUserDTO approver;

	

	@Override
	public int hashCode() {
		return Objects.hash(approval, approver);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApprovalConsumerDTO other = (ApprovalConsumerDTO) obj;
		return Objects.equals(approval, other.approval) && Objects.equals(approver, other.approver);
	}

	/**
	 * Empty Constructor
	 */
	public ApprovalConsumerDTO() {
		super();
	}

	/**
	 * @param approval
	 * @param approver
	 */
	public ApprovalConsumerDTO(ApprovalDTO approval, BasicUserDTO approver) {
		super();
		this.approval = approval;
		this.approver = approver;
	}

	/**
	 * @return the approval
	 */
	public ApprovalDTO getApproval() {
		return approval;
	}

	/**
	 * @param approval the approval to set
	 */
	public void setApproval(ApprovalDTO approval) {
		this.approval = approval;
	}

	/**
	 * @return the approver
	 */
	public BasicUserDTO getApprover() {
		return approver;
	}

	/**
	 * @param approver the approver to set
	 */
	public void setApprover(BasicUserDTO approver) {
		this.approver = approver;
	}
	
	
	
}
