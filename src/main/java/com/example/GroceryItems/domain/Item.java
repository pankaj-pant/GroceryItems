package com.example.GroceryItems.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String manufacturer;
	private int quantity;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "shopid")
	private Shop shop;
	
	public Item() {
		
	}
	
	public Item(String name, String manufacturer, int quantity, Shop shop) {
		super();
		this.name = name;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		this.shop = shop;
	}
	
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
	

	
	
}
