package com.poli.songstock.dto;

import java.util.Date;
import java.util.Objects;

public class ApprovalDTO {
	
	
	/**
	 * Title of the item
	 */
	private String title;

	/**
	 * Observation text
	 */
	private String obs;

	/**
	 * Application date
	 */
	private Date applicationDate;

	/**
	 * State of the item
	 */
	private String state;

	/**
	 * Code for identification
	 */
	private String code;

	/**
	 * Vinyl product data transfer object
	 */
	private ProductVinylDTO vinyl;

	
	

	@Override
	public int hashCode() {
		return Objects.hash(applicationDate, code, obs, state, title, vinyl);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApprovalDTO other = (ApprovalDTO) obj;
		return Objects.equals(applicationDate, other.applicationDate) && Objects.equals(code, other.code)
				&& Objects.equals(obs, other.obs) && Objects.equals(state, other.state)
				&& Objects.equals(title, other.title) && Objects.equals(vinyl, other.vinyl);
	}

	/**
	 * Empty Constructor
	 */
	public ApprovalDTO() {
		super();
	}

	/**
	 * @param title
	 * @param obs
	 * @param applicationDate
	 * @param state
	 * @param code
	 * @param vinyl
	 */
	public ApprovalDTO(String title, String obs, Date applicationDate, String state, String code,
			ProductVinylDTO vinyl) {
		super();
		this.title = title;
		this.obs = obs;
		this.applicationDate = applicationDate;
		this.state = state;
		this.code = code;
		this.vinyl = vinyl;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the obs
	 */
	public String getObs() {
		return obs;
	}

	/**
	 * @param obs the obs to set
	 */
	public void setObs(String obs) {
		this.obs = obs;
	}

	/**
	 * @return the applicationDate
	 */
	public Date getApplicationDate() {
		return applicationDate;
	}

	/**
	 * @param applicationDate the applicationDate to set
	 */
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the vinyl
	 */
	public ProductVinylDTO getVinyl() {
		return vinyl;
	}

	/**
	 * @param vinyl the vinyl to set
	 */
	public void setVinyl(ProductVinylDTO vinyl) {
		this.vinyl = vinyl;
	}
	
	
	
}
