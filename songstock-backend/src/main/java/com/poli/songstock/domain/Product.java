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
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private Integer isDigital;
	
	@Column(nullable = false)
	private Integer isSong;
	
	@Column(nullable = false)
	private Long objectId;
	
	@Column(nullable = false)
	private Long distributorId;

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
	 * @return the isDigital
	 */
	public Integer getIsDigital() {
		return isDigital;
	}

	/**
	 * @param isDigital the isDigital to set
	 */
	public void setIsDigital(Integer isDigital) {
		this.isDigital = isDigital;
	}

	/**
	 * @return the isSong
	 */
	public Integer getIsSong() {
		return isSong;
	}

	/**
	 * @param isSong the isSong to set
	 */
	public void setIsSong(Integer isSong) {
		this.isSong = isSong;
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

	/**
	 * @return the distributorId
	 */
	public Long getDistributorId() {
		return distributorId;
	}

	/**
	 * @param distributorId the distributorId to set
	 */
	public void setDistributorId(Long distributorId) {
		this.distributorId = distributorId;
	}
	
}
