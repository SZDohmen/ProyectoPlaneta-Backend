package com.planetas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.planetas.Entities.PlanetaEntity;

public interface PlanetaRepository extends JpaRepository<PlanetaEntity, Integer> {
	
}
