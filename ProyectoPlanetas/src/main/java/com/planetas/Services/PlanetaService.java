package com.planetas.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.planetas.DTO.PlanetaDTO;
import com.planetas.Entities.PlanetaEntity;
import com.planetas.Repository.PlanetaRepository;

@Service
public class PlanetaService implements ObjectServices <PlanetaDTO> {

	private PlanetaRepository repository;

	//Constructor
	public PlanetaService(PlanetaRepository repository) {
		this.repository = repository;
	}
	
	//Methods
	
	//----------FindAll----------
	@Transactional
	public List<PlanetaDTO> findAll() throws Exception {
		List<PlanetaEntity> planetas = repository.findAll();
		List<PlanetaDTO> listaDTO = new ArrayList<PlanetaDTO> ();
		
		try {
			for (PlanetaEntity planeta : planetas) {
			
				PlanetaDTO dto = new PlanetaDTO();
			
				dto.setId(planeta.getId());
				dto.setName(planeta.getName());
				dto.setSize(planeta.getSize());
				dto.setHabitable(planeta.getHabitable());
			
				listaDTO.add(dto);
			}		
			return listaDTO;
			
		} catch (Exception e) { throw new Exception(); }
	}
	
	//----------FindById----------
	@Transactional
	public PlanetaDTO findById(int id) throws Exception {
		
		Optional<PlanetaEntity> planetaOptional = repository.findById(id);
		
		try {
			PlanetaDTO dto = new PlanetaDTO();
			PlanetaEntity planeta = planetaOptional.get();
			
			dto.setId(id);
			dto.setName(planeta.getName());
			dto.setSize(planeta.getSize());
			dto.setHabitable(planeta.getHabitable());
			
			return dto;
			
		} catch (Exception e) { throw new Exception(); }
	}
	
	//----------Save----------
	@Transactional
	public PlanetaDTO save(PlanetaDTO dto) throws Exception {
		
		PlanetaEntity planeta = new PlanetaEntity();
		
		planeta.setId(dto.getId());
		planeta.setName(dto.getName());
		planeta.setSize(dto.getSize());
		planeta.setHabitable(dto.getHabitable());
		
		try {
			planeta = (PlanetaEntity) repository.save(planeta);
			dto.setId(planeta.getId());
			return dto;
			
		} catch (Exception e) { throw new Exception(); }		
	}
	
	//----------Update----------
	@Transactional
	public PlanetaDTO update(PlanetaDTO dto, int id) throws Exception {
		
		Optional<PlanetaEntity> planetaOptional = repository.findById(id);
		
		try {
			PlanetaEntity planeta = planetaOptional.get();
			
			planeta.setId(id);
			planeta.setName(dto.getName());
			planeta.setSize(dto.getSize());
			planeta.setHabitable(dto.getHabitable());
			
			repository.save(planeta);
			dto.setId(planeta.getId());		
			
			return dto;
		} catch (Exception e) { throw new Exception();}
	}
	
	//----------Delete----------
	  @Transactional
	  public boolean delete(int id) throws Exception{
		  try {
			  if(repository.existsById(id)) {
				  repository.deleteById(id);
				  return true;
			  } else {
				  throw new Exception();
			  }
		  } catch (Exception e) { throw new Exception();} }	 
	
}
