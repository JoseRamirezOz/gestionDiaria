package com.gestion.diaria.gestionDiaria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.diaria.gestionDiaria.entitys.GestionDiariaEntity;
import com.gestion.diaria.gestionDiaria.repository.GestionDiariaRepository;

@Service
public class GestionDiariaService {
	@Autowired GestionDiariaRepository gestionDiariaRepository;
	
	public List<GestionDiariaEntity> retornaTareas() {
		List<GestionDiariaEntity> list = new ArrayList<>();
		list = gestionDiariaRepository.findAll();
		return list;
	}
	
	public List<GestionDiariaEntity> obtenerTareasPendientes(String fechaActual) {
		List<GestionDiariaEntity> list = new ArrayList<>();
		list = gestionDiariaRepository.findTareasPendientes(fechaActual);
		return list;
	}
	
	public List<GestionDiariaEntity> navegarEntreSemanas(String fechaInicio,String fechaFin) {
		List<GestionDiariaEntity> list = new ArrayList<>();
		list = gestionDiariaRepository.findBetweenSemanas(fechaInicio, fechaFin);
		return list;
	}
	
	public List<GestionDiariaEntity> retornaSemanaActual() {
		List<GestionDiariaEntity> list = new ArrayList<>();
		list = gestionDiariaRepository.obtListSemanaActual();
		return list;
	}
	
	
	public void guardarTareas(GestionDiariaEntity gestionDiariaEntity) {
		gestionDiariaRepository.save(gestionDiariaEntity);
	}
	
	
	
	
	
}
