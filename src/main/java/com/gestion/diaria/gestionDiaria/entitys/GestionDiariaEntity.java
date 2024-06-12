package com.gestion.diaria.gestionDiaria.entitys;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table (name = "gestion_diaria")
@Data
public  class GestionDiariaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "DESC_ESTUDIE", length = 250)
	private String descEstudie;
	
	@ManyToOne 
	@JoinColumn(name = "DIA_SEMANA", referencedColumnName = "ID")
	private DiasSemanaEntity diaSemana;
	
	@Column(name = "FECHA")
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Column(name = "CUMPLIMIENTO")
	private int cumplimiento;
}
