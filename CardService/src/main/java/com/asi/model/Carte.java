package com.asi.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


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
	
	
	
	public Carte(int id, String name, String description, String imgurl, String family, String affinity, int hp,
			int energy, int attack, int defence, long price, LocalDate lastSoldDate) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.imgurl = imgurl;
		this.family = family;
		this.affinity = affinity;
		this.hp = hp;
		this.energy = energy;
		this.attack = attack;
		this.defence = defence;
		this.price = price;
		this.lastSoldDate = lastSoldDate;
	}
	

	@Override
	public String toString() {
		return "Carte [id=" + id + ", name=" + name + ", description=" + description + ", imgurl=" + imgurl
				+ ", family=" + family + ", affinity=" + affinity + ", hp=" + hp + ", energy=" + energy + ", attack="
				+ attack + ", defence=" + defence + ", price=" + price + ", lastSoldDate=" + lastSoldDate
				+ "]";
	}



	public long getPrice() {
		return price;
	}



	public void setPrice(long price) {
		this.price = price;
	}



	public LocalDate getlastSoldDate() {
		return lastSoldDate;
	}



	public void setlastSoldDate(LocalDate lastSoldDate) {
		this.lastSoldDate = lastSoldDate;
	}



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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

	public String getImgurl() {
		return imgurl;
	}



	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}


	
	
	
	public String getFamily() {
		return family;
	}



	public void setFamily(String family) {
		this.family = family;
	}



	public String getAffinity() {
		return affinity;
	}



	public void setAffinity(String affinity) {
		this.affinity = affinity;
	}



	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDefence() {
		return defence;
	}
	public void setDefence(int defence) {
		this.defence = defence;
	}
	
	
	

}
