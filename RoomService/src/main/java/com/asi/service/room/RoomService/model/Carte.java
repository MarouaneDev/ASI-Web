package com.asi.service.room.RoomService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
public class Carte {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String description;
	private String imgurl;
	private String family;
	private String affinity;
	private int hp;
	private int energy;
	private int attack;
	private int defence;
	private long price;
	private LocalDate lastSoldDate; 
	
	public Carte() {
		
	}
}
