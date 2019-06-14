package com.example.GroceryItems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.GroceryItems.domain.Item;
import com.example.GroceryItems.domain.ItemRepository;
import com.example.GroceryItems.domain.ShopRepository;

@Controller
public class ItemController {

	//Inject ItemRepository
	@Autowired
	private ItemRepository repository;

	//Inject ShopRepository
	@Autowired
	private ShopRepository srepository;

	// Login page
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	//Landing page
	@RequestMapping(value = { "/", "/itemlist", "/cancel" })
	public String itemList(Model model) {
		model.addAttribute("items", repository.findAll());
		return "itemlist";
	}

	//Add new item page
	@RequestMapping(value = "/add")
	public String addItem(Model model) {
		model.addAttribute("item", new Item());
		model.addAttribute("shops", srepository.findAll());
		return "additem";
	}

	//Edit item page
	@RequestMapping(value = "/edit/{id}")
	public String editItem(@PathVariable("id") Long itemId, Model model) {
		model.addAttribute("item", repository.findById(itemId));
		model.addAttribute("shops", srepository.findAll());
		return "edititem";
	}

	//Save
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Item item) {
		repository.save(item);
		return "redirect:itemlist";
	}

	//Delete a single item
	@PreAuthorize("hasAuthority('PARENT')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteItem(@PathVariable("id") Long itemId, Model model) {
		repository.deleteById(itemId);
		return "redirect:../itemlist";
	}

	//Clear entire list
	@PreAuthorize("hasAuthority('PARENT')")
	@RequestMapping(value = "/deleteall")
	public String deleteAll() {
		repository.deleteAll();
		return "itemlist";
	}

	// RESTful service to get all items
	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public @ResponseBody List<Item> itemListRest() {
		return (List<Item>) repository.findAll();
	}

	// RESTful service to get item by id
	@RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Item> findItemRest(@PathVariable("id") Long itemId) {
		return repository.findById(itemId);
	}

}
