package com.planetas.DTO;

import java.io.Serializable;


public class PlanetaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private Long size;
	private boolean habitable;
	
	//Constructors
	public PlanetaDTO() {}
	public PlanetaDTO(int id, String name, Long size, boolean habitable) {
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

	public boolean isHabitable() {
		return habitable;
	}
	public void setHabitable(boolean habitable) {
		this.habitable = habitable;
	}
	
		
}
