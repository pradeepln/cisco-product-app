package com.cisco.training.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cisco.training.domain.Product;
import com.cisco.training.service.ProductService;

@Component
public class ProductConsoleUI {
	
	ProductService service; // = new ProductServiceImpl();
	
	@Autowired
	public void setService(ProductService service) {
		this.service = service;
	}
	
	public void createProductWithUI() {
		
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Enter a Name: ");
		String name = kb.nextLine();
		
		System.out.println("Enter a Price: ");
		float price = Float.parseFloat(kb.nextLine());
		
		System.out.println("Enter a QoH: ");
		int qoh = Integer.parseInt(kb.nextLine());
		
		Product p = new Product(name, price, qoh);
		int id = service.addNewProduct(p);
		System.out.println("Added Product with Id "+id);
	}

}
