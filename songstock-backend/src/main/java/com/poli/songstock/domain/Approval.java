package com.poli.songstock.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table

public class Approval {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private LocalDate applicantDate;
	
	@Column(nullable = false)
	private String title;
	
	private String obs;
	
	@Enumerated(EnumType.STRING)
	private Approval.State state;
	
	@Column(unique = true, nullable = false)
	private String code;
	
	@Column(nullable = false)
	private Long applicantId;
	
	@Column(nullable = false)
	private Long approverId;
	
	@Column(nullable = false)
	private Long objectId;
	
	public enum State {
		ACEPTADO,
		RECHAZADO,
		PENDIENTE
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the applicantDate
	 */
	public LocalDate getApplicantDate() {
		return applicantDate;
	}

	/**
	 * @param applicantDate the applicantDate to set
	 */
	public void setApplicantDate(LocalDate applicantDate) {
		this.applicantDate = applicantDate;
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
	 * @return the state
	 */
	public Approval.State getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(Approval.State state) {
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
	 * @return the applicantId
	 */
	public Long getApplicantId() {
		return applicantId;
	}

	/**
	 * @param applicantId the applicantId to set
	 */
	public void setApplicantId(Long applicantId) {
		this.applicantId = applicantId;
	}

	/**
	 * @return the approverId
	 */
	public Long getApproverId() {
		return approverId;
	}

	/**
	 * @param approverId the approverId to set
	 */
	public void setApproverId(Long approverId) {
		this.approverId = approverId;
	}

	/**
	 * @return the objectId
	 */
	public Long getObjectId() {
		return objectId;
	}

	/**
	 * @param objectId the objectId to set
	 */
	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}
	
	
}
