package com.gestion.diaria.gestionDiaria.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.diaria.gestionDiaria.entitys.GestionDiariaEntity;
import com.gestion.diaria.gestionDiaria.service.GestionDiariaService;

@RestController
public class GestionDiariaController {
	@Autowired GestionDiariaService gestionDiariaService;
	
	@GetMapping("/obtener-tareas")
	public List<GestionDiariaEntity>  funcionSaludar() {
		List<GestionDiariaEntity> list = new ArrayList<>();
		list = gestionDiariaService.retornaTareas();
		return list;
	}
	
	@GetMapping("/obtener-semana-actual")
	public List<GestionDiariaEntity> obtenerSemanaActual(){
		List<GestionDiariaEntity> list = new ArrayList<>();
		list = gestionDiariaService.retornaSemanaActual();
		return list;
	}
	
	@GetMapping("/obtener-tareas-pendientes/{fechaActual}")
	public List<GestionDiariaEntity> obtenerTareasPendientes(@PathVariable String fechaActual){
		List<GestionDiariaEntity> list = new ArrayList<>();
		list = gestionDiariaService.obtenerTareasPendientes(fechaActual);
		return list;
	}
	
	
	@GetMapping("/navegar-entre-semanas/{fechaInicio}/{fechaFin}")
	public List<GestionDiariaEntity> navegarEntreSemanas(@PathVariable String fechaInicio, @PathVariable String fechaFin){
		List<GestionDiariaEntity> list = new ArrayList<>();
		list = gestionDiariaService.navegarEntreSemanas(fechaInicio,fechaFin);
		return list;
	}
	
	
	
	@PostMapping("/crear-tarea")
	public void crearTarea(@RequestBody GestionDiariaEntity gestionDiaria) {
		gestionDiariaService.guardarTareas(gestionDiaria);
	}
	
	
}




