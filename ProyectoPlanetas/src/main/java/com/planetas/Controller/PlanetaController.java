package com.planetas.Controller;

import javax.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.planetas.DTO.PlanetaDTO;
import com.planetas.Services.PlanetaService;

@RestController
@RequestMapping("avi/v1/planetas")
@CrossOrigin(origins = "*" , methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PlanetaController implements ObjectController<PlanetaDTO> {

	PlanetaService service;

	//Constructor
	public PlanetaController(PlanetaService service) {
		super();
		this.service = service;
	}
	
	//Methods
		
	//----------GetAll----------
	@GetMapping("/")
	@Transactional
	public ResponseEntity getAll() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findAll());			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error al buscar registros");
		}
	}
	
	//----------GetOne----------
	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity getOne(@PathVariable int id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro no encontrado");
		}
	}
	
	//----------Post----------
	@PostMapping("/")
	@Transactional
	public ResponseEntity post(@RequestBody PlanetaDTO dto) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.save(dto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear");
		}
	}
	
	//----------Put----------
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity put(@RequestBody PlanetaDTO dto, @PathVariable int id) {
		try {
			service.update(dto, id);
			return ResponseEntity.status(HttpStatus.OK).body("Registro actualizado");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al actualziar registro");
		}
	}
	
	//----------Delete----------
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity delete(@PathVariable int id) {
		try {
			service.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body("Registro eliminado");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar registro");
		}
	}	
}
