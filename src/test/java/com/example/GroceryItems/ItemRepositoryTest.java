package com.example.GroceryItems;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.GroceryItems.domain.Item;
import com.example.GroceryItems.domain.ItemRepository;
import com.example.GroceryItems.domain.Shop;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

	@Autowired
	private ItemRepository repository;

	//Test for checking if newly created Item has id
	@Test
	public void createNewItem() {
		Item item = new Item("Chewing Gum", "Wrigleys", 5, new Shop("R-kiosk"));
		repository.save(item);
		assertThat(item.getId()).isNotNull();
	}

	//Test for checking if delete all completely removes all items
	@Test
	public void deleteAllItems() {
		repository.deleteAll();
		assertThat(repository.count()).isEqualTo(0);
	}

}
