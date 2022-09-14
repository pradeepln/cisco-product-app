package com.cisco.training.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cisco.training.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	public List<Product> findByName(String name);
	public List<Product> findByNameLike(String name);
	public List<Product> findByPriceLessThan(float price);
	
	@Query("select p from Product p where p.qoh>:qParam")
	public List<Product> myComplexQuery(@Param("qParam") int q);
}
