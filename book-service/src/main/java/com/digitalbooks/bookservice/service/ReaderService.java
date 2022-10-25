package com.digitalbooks.bookservice.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbooks.bookservice.entity.BuyBook;
import com.digitalbooks.bookservice.repository.BuyRepository;

@Service
public class ReaderService {

//	@Autowired
//	BookRepository bookRepo;

	@Autowired
	BuyRepository buyRepo;



	public List<BuyBook> getAllPurchasedBooks(String emailId) {
		return buyRepo.findByEmail(emailId);
	}

	public String getByEmailandId(String emailId, int bookId) {

		return buyRepo.filterByBookId(emailId, bookId);
	}

	public String getPurchasedBookByPid(String emailId, long generatedId) {
		return buyRepo.findByPid(emailId, generatedId);
	}

	public String checkIfRefundIsValid(String emailId, int bookId) {
		// long seconds,minutes,hours,years;
		long days = 0;
		String start = buyRepo.getDateFromBuyBook(bookId);
		System.out.println("date from buybook table" + start);
		if (start != null) {
			DateTimeFormatter dlf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			String end = dlf.format(now);
			// logic for find time difference
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

			try {
				Date d1 = sdf.parse(start);
				Date d2 = sdf.parse(end);
				long difference_In_Time = d2.getTime() - d1.getTime();

				days = TimeUnit.MILLISECONDS.toDays(difference_In_Time) % 365;

				System.out.println("days" + days);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (days < 1) {
				buyRepo.deleteById(bookId);
				return "refund success";
			} else {
				return "subscription is valid for upto 24 hours";
			}

		} else {
			return "book id doesn't exist,Please enter existing boook id";
		}

	}
}
