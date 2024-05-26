package com.poli.songstock.domain;

import java.time.LocalDate;

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

	private LocalDate applicantDate;
	
	private String title;
	
	private String obs;
	
	@Enumerated(EnumType.STRING)
	private Approval.State state;
	
	private String code;
	
	private Long applicantId;
	
	private Long approverId;
	
	private Long objectId;
	
	public enum State {
		ACEPTADO,
		RECHAZADO,
		PENDIENTE
	}
}
