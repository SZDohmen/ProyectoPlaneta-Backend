package com.planetas.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Planetas")
public class PlanetaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="NombrePlaneta")
	private String name;
	
	@Column(name="TamañoPlaneta")
	private Long size;
	
	@Column(name="VidaEnPlaneta")
	private boolean habitable;

	//Constructors
	public PlanetaEntity() { }		
	public PlanetaEntity(int id, String name, Long size, boolean habitable) {
		this.id = id;
		this.name = name;
		this.size = size;
		this.habitable = habitable;
	}
	
	//Getters & Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	
	public boolean getHabitable() {
		return habitable;
	}
	public void setHabitable(boolean habitable) {
		this.habitable = habitable;
	}
	
	
}
