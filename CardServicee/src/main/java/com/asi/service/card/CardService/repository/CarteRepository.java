package com.asi.service.card.CardService.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.asi.service.card.CardService.model.Carte;

public interface CarteRepository extends CrudRepository<Carte, Integer> {

	public List<Carte> findByName(String name);
}
