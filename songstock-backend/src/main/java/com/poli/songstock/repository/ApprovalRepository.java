package com.poli.songstock.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.poli.songstock.domain.Approval;


public interface ApprovalRepository extends JpaRepository<Approval, Long> {

	/*
	@Query(value = "DELETE FROM aprobacion a WHERE a.codigo = :codigo", nativeQuery = true)
	void deleteByCodigo(@Param("codigo") String codigo);
	
	@Query(value = "SELECT * FROM aprobacion a WHERE a.codigo = :codigo", nativeQuery = true)
	Optional<AprobacionDTO> findByCodigo(@Param("codigo") String codigo);
	*/
}
