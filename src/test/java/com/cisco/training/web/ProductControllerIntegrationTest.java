package com.cisco.training.web;

import static org.junit.jupiter.api.Assertions.*;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.cisco.training.ProductAppApplication;
import com.cisco.training.dal.ProductDAO;
import com.cisco.training.domain.Product;
import com.cisco.training.service.ProductService;

@SpringBootTest(classes = {ProductAppApplication.class}, webEnvironment = WebEnvironment.MOCK)
@TestPropertySource("classpath:application-test.properties")
@AutoConfigureMockMvc
class ProductControllerIntegrationTest {

	@Autowired
	ProductDAO dao;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	void testGetProductById() throws Exception {
		//AAA
		//Arrange
		Product sample = new Product("test", 10_000, 1);
		Product saved = dao.save(sample);
		int id = saved.getId();
		
		
		//Act and Assert
		
			mockMvc
				.perform(MockMvcRequestBuilders.get("/products/{id}", id))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(id)));
		
		
		
	}

}
