package com.sp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.Carte;
import com.sp.model.User;
import com.sp.service.CarteService;
import com.sp.service.UserService;

@RestController
public class CarteRestCrt {
	
	@Autowired
	CarteService cService;
	UserService uService;
	
	@RequestMapping(method=RequestMethod.POST,value="/carte")
    public void addCarte(@RequestBody Carte carte) {
		cService.addCarte(carte);
    }
	
	@RequestMapping(method=RequestMethod.GET,value="/carte/{id}")
    public Carte getCarte(@PathVariable String id) {
        Carte c=cService.getCarte(Integer.valueOf(id));
        return c;
    }
	
	@RequestMapping(method=RequestMethod.GET,value="/cartes")
    public List<Carte> listCarte() {
		List<Carte> allcards = cService.listCarte();
		if(allcards.isEmpty()) {
			return null;
		} else {
			return allcards;
		}
    }
	
	@RequestMapping(method=RequestMethod.POST,value="/buy/carte/{cardId}")
    public void buyCard(@PathVariable String cardId, int userId) {
        Carte c = cService.getCarte(Integer.valueOf(cardId));
        User u = uService.getUser(userId);
		cService.buyCard(c, u);
		
    }
	
	@RequestMapping(method=RequestMethod.POST,value="/sell/carte/{cardId}")
    public void sellCard(@PathVariable String cardId, String userId) {
		Carte c = cService.getCarte(Integer.valueOf(cardId));
        User u = uService.getUser(Integer.valueOf(userId));
		cService.sellCard(c, u);
    }



}
