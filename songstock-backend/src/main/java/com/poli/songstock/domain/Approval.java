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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Approval {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "applicant_date")
	private LocalDate applicantDate;
	
	private String title;
	
	private String obs;
	
	@Enumerated(EnumType.STRING)
	private Approval.State state;
	
	private String code;
	
	@Column(name = "applicant_id")
	private String applicantId;
	
	@Column(name = "approver_id")
	private String approverId;
	
	@Column(name = "object_id")
	private String objectId;
	
	public enum State {
		ACEPTADO,
		RECHAZADO,
		PENDIENTE
	}
}
