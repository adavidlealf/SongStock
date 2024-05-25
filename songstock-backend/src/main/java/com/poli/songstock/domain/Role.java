package com.poli.songstock.domain;

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
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 32)
	private Long id;
	
	private String name;
	
	@Column(name = "can_see")
	private String canSee;
	
	@Column(name = "can_modify")
	private String canModify;

}