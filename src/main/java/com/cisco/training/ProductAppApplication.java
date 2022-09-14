package com.cisco.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cisco.training.dal.ProductRepository;
import com.cisco.training.domain.Product;
import com.cisco.training.ui.ProductConsoleUI;

@SpringBootApplication
public class ProductAppApplication {

	
	
	
	public static void main(String[] args) {
		ApplicationContext springContainer = 
				SpringApplication.run(ProductAppApplication.class, args);
//		ProductConsoleUI ui = springContainer.getBean(ProductConsoleUI.class);
//		ui.createProductWithUI();
		
//		testRepository(springContainer);
	}

	private static void testRepository(ApplicationContext springContainer) {
		ProductRepository repo = springContainer.getBean(ProductRepository.class);
		
		Product sample = new Product("repo", 12345, 100);
		
		Product saved = repo.save(sample);
		System.out.println("Saved Product with id: "+saved.getId());
	}

}
