package com.example.GroceryItems;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.GroceryItems.domain.User;
import com.example.GroceryItems.domain.UserRepository;
import com.example.GroceryItems.domain.Item;
import com.example.GroceryItems.domain.ItemRepository;
import com.example.GroceryItems.domain.Shop;
import com.example.GroceryItems.domain.ShopRepository;

@SpringBootApplication
public class GroceryItemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroceryItemsApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ItemRepository repository, ShopRepository srepository, UserRepository urepository) {

		return (args) -> {

			// Save Shops to ShopRepository
			srepository.save(new Shop("Lidl"));
			srepository.save(new Shop("K-Citymarket"));
			srepository.save(new Shop("S-Market"));

			// Create Items
			Item item1 = new Item("Sliced bread", "Fazer", 2, srepository.findByName("Lidl").get(0));
			Item item2 = new Item("Cheese", "Valio", 1, srepository.findByName("K-Citymarket").get(0));
			Item item3 = new Item("Butter", "Valio", 1, srepository.findByName("S-Market").get(0));

			// Save items to ItemRepository
			repository.save(item1);
			repository.save(item2);
			repository.save(item3);

			// Create users: child/child and parent/parent
			User user1 = new User("child", "$2a$10$03T10f0cXJ6JMl9ftE6LT.Hs7Q/BGHvl56T6T5kCWiI6Bspi6hDOC",
					"child@shoppinglist.com", "CHILD");
			User user2 = new User("parent", "$2a$10$VKvPbrB0ZwSEyBP1G7/nNu7HwA2fw0DnzmTzr8jShrTUcM6ZX/r3.",
					"parent@shoppinglist.com", "PARENT");

			//Save users to UserRepository
			urepository.save(user1);
			urepository.save(user2);

		};
	}
}
