package com.cisco.training.service;

import java.util.List;

import com.cisco.training.domain.Product;

public interface ProductService {
	
	int addNewProduct(Product toBeAdded);
	void removeExisting(int id);
	
	Product findById(int id);
	List<Product> findAll();

}
