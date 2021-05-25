package com.sp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Carte;
import com.sp.model.User;
import com.sp.repository.CarteRepository;


@Service
public class CarteService {
	@Autowired
	CarteRepository cRepository;
	
	
	public void addCarte(Carte c) {
		Carte createdCarte=cRepository.save(c);
		System.out.println(createdCarte);
	}
	
	public Carte getCarte(int id) {
		Optional<Carte> cOpt =cRepository.findById(id);
		if (cOpt.isPresent()) {
			return cOpt.get();
		}else {
			return null;
		}
	}
	
	public List<Carte> listCarte() {
		Iterable<Carte> cards = cRepository.findAll();
		long size = cards.spliterator().getExactSizeIfKnown();
		if(size > 0) {
			List<Carte> allCards = new ArrayList<>();
			cards.forEach(allCards::add);
			return allCards;			
		} else {
			return null;
		}
	}
	
	public void buyCard(Carte c, User u) {
		if (u.getWalletAmount() >= c.getPrice()) {
			long newBalance = u.decreaseWallet(c.getPrice());
			u.setWalletAmount(newBalance);
			c.setlastSoldDate(LocalDate.now());
			u.addOwnedCard(c);
		}
	}
	
	public void sellCard(Carte c, User u) {
		List<Carte> ownedCards = u.getOwnedCards();
		if(ownedCards.contains(c)) {
			long newBalance = u.increaseWallet(c.getPrice());
			u.setWalletAmount(newBalance);
			u.removeOwnedCard(c);
		}
	}
		

}

