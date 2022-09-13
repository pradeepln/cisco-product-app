package com.cisco.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cisco.training.dal.ProductDAO;
import com.cisco.training.dal.ProductDAOInMemImpl;

@Service
public class SpecialUseCaseService {
	
	ProductDAO dao;
	
	@Qualifier("productDAOInMemImpl")
	@Autowired
	public void setDao(ProductDAO dao) {
		this.dao = dao;
		System.out.println("[[[[ Inside special service "+dao.getClass().getName()+" ]]]]");
	}

}
