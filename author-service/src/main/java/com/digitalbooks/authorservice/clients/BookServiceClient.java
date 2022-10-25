package com.digitalbooks.authorservice.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.digitalbooks.authorservice.model.BookEntity;

import feign.Headers;
@FeignClient(name="book-service",url="localhost:8081")
public interface BookServiceClient {
	
	@PostMapping("/api/v1/digitalbooks/books/createbook")
	@Headers("Content-Type: application/json")
	BookEntity SaveBook(BookEntity book);
	
	@PutMapping("/api/v1/digitalbooks/books/update")
    @Headers("Content-Type: application/json")
	BookEntity updateBook(BookEntity book);

}
