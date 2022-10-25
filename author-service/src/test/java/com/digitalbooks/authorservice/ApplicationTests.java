package com.digitalbooks.authorservice;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.digitalbooks.authorservice.controller.AuthorController;
import com.digitalbooks.authorservice.model.AuthorDetails;
import com.digitalbooks.authorservice.service.AuthorService;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}

	
	@Mock
    AuthorService authorservice;
	
	@InjectMocks
	AuthorController authorController;
	@Test
	public void registerTest() {
        AuthorDetails authorEntity = new AuthorDetails();
        authorEntity.setAuthorEmailId("thanuja@gmail.com");
        authorEntity.setaId(1);
        authorEntity.setUsername("thanuja");
        authorEntity.setPassword("chilamkurthy");


       when(authorservice.save(authorEntity)).thenReturn(authorEntity);
       authorController.saveCredentials(authorEntity);
	}
}
