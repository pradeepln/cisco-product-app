//package com.cisco.training;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.cisco.training.dal.ProductDAO;
//import com.cisco.training.dal.ProductDAOInMemImpl;
//import com.cisco.training.service.ProductService;
//import com.cisco.training.service.ProductServiceImpl;
//import com.cisco.training.ui.ProductConsoleUI;
//
//@Configuration
//public class ProductAppConfiguration {
//
//	@Bean
//	public ProductDAO daoObj() {
//		ProductDAOInMemImpl dao = new ProductDAOInMemImpl();
//		return dao;
//	}
//	
//	@Bean
//	public ProductService serviceObj() {
//		ProductServiceImpl service = new ProductServiceImpl();
//		service.setDao(daoObj());
//		return service;
//	}
//	
//	@Bean
//	public ProductConsoleUI uiObj() {
//		ProductConsoleUI ui = new ProductConsoleUI();
//		ui.setService(serviceObj());
//		return ui;
//	}
//}
