package com.example.GroceryItems.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;

	//Relationship
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "shop")
	private List<Item> items;

	//Constructor
	public Shop() {

	}

	//Constructor
	public Shop(String name) {
		super();
		this.name = name;
	}

	//Getters and Setters
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
