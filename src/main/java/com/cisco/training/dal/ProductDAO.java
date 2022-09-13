package com.cisco.training.dal;

import java.util.List;

import com.cisco.training.domain.Product;

public interface ProductDAO {
	
	Product save(Product toBeSaved);
	Product findById(int id);
	List<Product> findAll();
	void deleteById(int id);
	void updateDetached(Product existing);
	
}
