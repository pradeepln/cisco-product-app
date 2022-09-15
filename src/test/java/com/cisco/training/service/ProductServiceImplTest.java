package com.cisco.training.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cisco.training.dal.ProductDAOInMemImpl;
import com.cisco.training.domain.Product;

class ProductServiceImplTest {

	@Test
	void addNewProduct_Returns_Valid_Id_When_ProductValue_GTEQ_MinValue() {
		//Fast Independent Repeatable Selfvalidating Timely
		//AAA
		//Arrange
		ProductServiceImpl objectUnderTest = new ProductServiceImpl();
		Product paramToTestMethod = new Product("test", ProductServiceImpl.MIN_PRODUCT_VALUE, 1);
		ProductDAOInMemImpl fakeDAO = new ProductDAOInMemImpl();
		objectUnderTest.setDao(fakeDAO);
		//Act
		int id = objectUnderTest.addNewProduct(paramToTestMethod);
		//Assert
		assertTrue(id > 0);
	}

}
