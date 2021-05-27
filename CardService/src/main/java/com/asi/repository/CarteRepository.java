package com.asi.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.asi.model.Carte;

public interface CarteRepository extends CrudRepository<Carte, Integer> {

	public List<Carte> findByName(String name);
}
