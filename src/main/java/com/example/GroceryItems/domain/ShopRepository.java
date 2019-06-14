package com.example.GroceryItems.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface ShopRepository extends CrudRepository<Shop, Long> {
	
	List<Shop> findByName(String shopname);

}
