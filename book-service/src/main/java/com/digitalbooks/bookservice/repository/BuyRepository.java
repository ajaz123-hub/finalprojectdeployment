package com.digitalbooks.bookservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.digitalbooks.bookservice.entity.BuyBook;

public interface BuyRepository extends JpaRepository<BuyBook, String> {

	@Query("select D from BuyBook D where D.emailId=:emailId")
	List<BuyBook> findByEmail(String emailId);

	@Query("select D.bookName from BuyBook D where D.emailId=emailId and D.bookId=bookId")
	public String filterByBookId(String emailId, int bookId);

	@Query("select D.bookName from BuyBook D where D.bookId=?1")
	public String findByBookName(int bookId);

	@Query("select D.bookName from BuyBook D where D.emailId=?1 and D.generatedId=?2")
	public String findByPid(String emailId, long generatedId);

	//Query for getting date by using bookid
    @Query("select D.date from BuyBook D where D.bookId=?1")
    public String getDateFromBuyBook(int bookId);
    @Transactional
    @Modifying
    @Query("delete from BuyBook D where D.bookId=?1")
    public void deleteById(int bookId);

}
