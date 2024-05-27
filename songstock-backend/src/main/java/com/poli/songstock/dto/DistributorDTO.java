package com.poli.songstock.dto;

import java.util.List;
import java.util.Objects;

public class DistributorDTO {
	
	private UserRoleDTO userRole;
	
	private List<ApprovalDistributorDTO> approvals;
	
	private CatalogueDTO catalogue;
	


	@Override
	public int hashCode() {
		return Objects.hash(approvals, catalogue, userRole);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DistributorDTO other = (DistributorDTO) obj;
		return Objects.equals(approvals, other.approvals) && Objects.equals(catalogue, other.catalogue)
				&& Objects.equals(userRole, other.userRole);
	}

	/**
	 * 
	 */
	public DistributorDTO() {
		super();
	}

	/**
	 * @param userRole
	 * @param approvals
	 * @param catalogue
	 */
	public DistributorDTO(UserRoleDTO userRole, List<ApprovalDistributorDTO> approvals, CatalogueDTO catalogue) {
		super();
		this.userRole = userRole;
		this.approvals = approvals;
		this.catalogue = catalogue;
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
	public List<ApprovalDistributorDTO> getApprovals() {
		return approvals;
	}

	/**
	 * @param approvals the approvals to set
	 */
	public void setApprovals(List<ApprovalDistributorDTO> approvals) {
		this.approvals = approvals;
	}

	/**
	 * @return the catalogue
	 */
	public CatalogueDTO getCatalogue() {
		return catalogue;
	}

	/**
	 * @param catalogue the catalogue to set
	 */
	public void setCatalogue(CatalogueDTO catalogue) {
		this.catalogue = catalogue;
	}
	
	

}
