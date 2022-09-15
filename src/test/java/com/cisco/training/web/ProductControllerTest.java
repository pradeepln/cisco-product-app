package com.cisco.training.web;

import static org.junit.jupiter.api.Assertions.*;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.cisco.training.domain.Product;
import com.cisco.training.service.ProductService;

@WebMvcTest(controllers = {ProductController.class})
class ProductControllerTest {

	@MockBean
	ProductService mockService;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	void testGetProductById() throws Exception {
		//AAA
		//Arrange
		int id = 1;
		Product dataReturnedByMock = new Product("test", 10_000, 1);
		dataReturnedByMock.setId(id);
		Mockito.when(mockService.findById(id)).thenReturn(dataReturnedByMock);
		
		//Act and Assert
		
			mockMvc
				.perform(MockMvcRequestBuilders.get("/products/{id}", id))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(id)));
		
		
		
	}

}
