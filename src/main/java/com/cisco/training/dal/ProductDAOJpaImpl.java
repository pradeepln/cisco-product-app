package com.cisco.training.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cisco.training.domain.Product;

@Transactional
@Primary
@Repository
public class ProductDAOJpaImpl implements ProductDAO {

	@Autowired
	private EntityManager em;
	
	@Override
	public Product save(Product toBeSaved) {
		//if caller not started tx, begin tx
		//toBeSaved ------> new
		em.persist(toBeSaved);
		//toBeSaved ------> managed
		//toBeSaved.setPrice(998);
		return toBeSaved;
		//if started here, commit tx
	}

	@Override
	public Product findById(int id) {
		Product p = em.find(Product.class, id);
		//p ----> managed
		return p;
	}

	@Override
	public List<Product> findAll() {
		Query q = em.createQuery("seLeCt p from Product as p");
		return q.getResultList();
	}

	@Override
	public void deleteById(int id) {
//		Product p = em.find(Product.class, id);
		//p ----> managed
//		em.remove(p);
		//p ----> new
		
		Query q = em.createQuery("delete from Product p where p.id=:idParam");
		q.setParameter("idParam", id);
		q.executeUpdate();
	}
	
	
//	public void changePrice(int id, float newPrice) {
//		Product existing = em.find(Product.class, id);
//		if(existing != null) {
//			existing.setPrice(newPrice);
//		}
//	}
	
	@Override
	public void updateDetached(Product existing) {
		em.merge(existing);
		
	}

}
