package com.cisco.training.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cisco.training.dal.ProductDAO;
import com.cisco.training.dal.ProductDAOInMemImpl;
import com.cisco.training.domain.Product;

@ExtendWith(MockitoExtension.class)
class MockitoAnnotationProductServiceImplTest {

	@Mock
	ProductDAO mockDAO;
	
	@Test
	void addNewProduct_Returns_Valid_Id_When_ProductValue_GTEQ_MinValue() {
		//Fast Independent Repeatable Selfvalidating Timely
		//AAA
		//Arrange
		ProductServiceImpl objectUnderTest = new ProductServiceImpl();
		Product paramToTestMethod = new Product("test", ProductServiceImpl.MIN_PRODUCT_VALUE, 1);
		
		
		objectUnderTest.setDao(mockDAO);
		
		Product returnedByMock = new Product("test", ProductServiceImpl.MIN_PRODUCT_VALUE, 1);
		returnedByMock.setId(1);
		Mockito.when(mockDAO.save(paramToTestMethod)).thenReturn(returnedByMock);
		
		//Act
		int id = objectUnderTest.addNewProduct(paramToTestMethod);
		//Assert
		assertTrue(id > 0);
	}

}
