package com.cisco.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cisco.training.dal.ProductDAO;

import com.cisco.training.domain.Product;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductDAO dao; // = new ProductDAOInMemImpl();
	
	@Autowired
	public void setDao(ProductDAO dao) {
		this.dao = dao;
		System.out.println("<<<<< Type of dao injected is "+dao.getClass().getName()+" >>>>>");
	}
	
	@Override
	public int addNewProduct(Product toBeAdded) {
		if(toBeAdded.getPrice() * toBeAdded.getQoh() < 10_000) {
			throw new IllegalArgumentException("Expected product value to be >= 10k, but was " + toBeAdded.getPrice() * toBeAdded.getQoh());
		}else {
			Product saved = dao.save(toBeAdded);
			//saved ----> detached
			return saved.getId();
		}
	}

	@Override
	public void removeExisting(int id) {
		Product existing = dao.findById(id);
		if(existing.getPrice() * existing.getQoh() >= 100_000) {
			throw new IllegalStateException("Can't delete when value GTEQ 100k....");
		}else {
			dao.deleteById(id);
		}
	}

	@Override
	public Product findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Product> findAll() {
		return dao.findAll();
	}

	
	public void changePrice(int id, float newPrice) {
		Product existing = dao.findById(id);
		existing.setPrice(newPrice);
		//dao.updateDetached(existing);
	}
	
}
