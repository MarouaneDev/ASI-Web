package com.asi.service.card.CardService;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.asi.service.card.CardService.model.Carte;
import com.asi.service.card.CardService.service.CarteService;
import com.asi.service.card.CardService.service.UserService;
import com.asi.service.card.CardService.model.User;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CardServiceApplicationTests {

	Carte card = new Carte(1, "Darxul", "Marche avec les mains", ":-)", "Nwar", "Pieds", 100,
	60, 50, 500, 9000, null);

	Carte card1 = new Carte(1, "Paull", "Ses ancetres", ":-)", "Gwere", "Lounette", 100,
			60, 50, 500, 9000, null);

	Carte card2 = new Carte(1, "PartaBasu", "CuryOMax", ":-)", "Marron", "Cancer", 100,
			60, 50, 500, 9000, null);

	User user = new User("Meruem", "meruem@ant.fr", "oui");

	@Autowired
	CarteService cardService = new CarteService();

	@Autowired
	UserService userService = new UserService();

	@Test
	@Order(1)
	void add_get_CardTest() {
		cardService.addCarte(card);
		assertEquals(cardService.getCarte(card.getId()).getName(), card.getName());
	}

	@Test
	@Order(2)
	void listCarteTest(){
		assertEquals(4, cardService.listCarte().size());
	}

	@Test
	@Order(3)
	void buy_sell_CardTest(){
		user.increaseWallet(20000);
		cardService.buyCard(card, user);
		assertEquals(card.getName(), user.getOwnedCards().get(0).getName());
		long wallet = user.getWalletAmount();
		cardService.sellCard(user.getOwnedCards().get(0), user);
		assertNotEquals(wallet, user.getWalletAmount());
	}

}