package com.digitalbooks.bookservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digitalbooks.bookservice.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity,Integer>{

	
	@Query("select D from BookEntity D where D.authorId=?1 and D.bookId=?2")
	Optional<BookEntity> getBookDetailsByBookIdAndAuthorId(int authorId, int bookId);

	@Query("select D from BookEntity D where D.category=?1 and authorName=?2 and price=?3 and publisher=?4")
    List<BookEntity> findbycap(String category, String authorName, double price, String publisher);

	
	

}
