package com.poli.songstock.dto;

import java.util.Objects;

public class ApprovalDistributorDTO {
	
	private ApprovalDTO approval;
	
	private BasicUserDTO applicant;
	
	

	@Override
	public int hashCode() {
		return Objects.hash(applicant, approval);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApprovalDistributorDTO other = (ApprovalDistributorDTO) obj;
		return Objects.equals(applicant, other.applicant) && Objects.equals(approval, other.approval);
	}

	/**
	 * 
	 */
	public ApprovalDistributorDTO() {
		super();
	}

	/**
	 * @param approval
	 * @param applicant
	 */
	public ApprovalDistributorDTO(ApprovalDTO approval, BasicUserDTO applicant) {
		super();
		this.approval = approval;
		this.applicant = applicant;
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
	 * @return the applicant
	 */
	public BasicUserDTO getApplicant() {
		return applicant;
	}

	/**
	 * @param applicant the applicant to set
	 */
	public void setApplicant(BasicUserDTO applicant) {
		this.applicant = applicant;
	}
	
	
	
}