package com.vaccine.bookvaccination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaccine.bookvaccination.service.BookService;

@RestController
@RequestMapping("/api/booking-service/v1")
public class BookServiceController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/test")
	public String test(){
		return "Ok";
	}
	
	@GetMapping("/book-vaccine")
	public String bookVaccine() {
		return bookService.bookVaccineSlot();
	}
}
