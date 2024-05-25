package com.poli.songstock.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 32)
	private Long id;

	@Column(name = "applicant_date")
	private LocalDate applicantDate;
	
	private String nickname;
	
	private String name;
	
	private String email;

	private String password;

	private LocalDate birthdate;
	
	@Column(name = "role_id", length = 32)
	private String roleId;
}