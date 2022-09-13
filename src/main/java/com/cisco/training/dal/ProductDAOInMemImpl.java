package com.cisco.training.dal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cisco.training.domain.Product;

@Repository
public class ProductDAOInMemImpl implements ProductDAO {

	Map<Integer, Product> db = new HashMap<Integer, Product>();
	int idSequence = 0;
	
	public Product save(Product toBeSaved) {
		int id = ++idSequence;
		toBeSaved.setId(id);
		db.put(toBeSaved.getId(), toBeSaved);
		return toBeSaved;
	}

	public Product findById(int id) {
		return db.get(id);
	}

	public List<Product> findAll() {
		return new ArrayList<Product>(db.values());
	}

	public void deleteById(int id) {
		db.remove(id);		
	}

	@Override
	public void updateDetached(Product existing) {
		// TODO Auto-generated method stub
		
	}

}
