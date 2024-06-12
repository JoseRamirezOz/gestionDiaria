package com.gestion.diaria.gestionDiaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gestion.diaria.gestionDiaria.entitys.GestionDiariaEntity;

@Repository
public interface GestionDiariaRepository extends JpaRepository<GestionDiariaEntity, Integer>{
	@Query(value = "SELECT * FROM gestion_diaria WHERE FECHA BETWEEN (SELECT DATE(DATE_ADD(NOW(), INTERVAL -WEEKDAY(NOW()) DAY)) PRIMER_DIA)\r\n"
			+ " AND (SELECT DATE(DATE_ADD(DATE(NOW()), INTERVAL -WEEKDAY(NOW()) DAY)+6) ULTIMO_DIA)", nativeQuery = true)
	List<GestionDiariaEntity> obtListSemanaActual();
	
	
	@Query(value = "SELECT * FROM gestion_diaria WHERE CUMPLIMIENTO = 0 AND FECHA < ?;", nativeQuery = true)
	List<GestionDiariaEntity> findTareasPendientes(String fechaActual);
	
	@Query(value = "SELECT * FROM gestion_diaria WHERE FECHA BETWEEN ? AND ?", nativeQuery = true)
	List<GestionDiariaEntity> findBetweenSemanas(String fechaInicio, String fechaFin);
	
}
