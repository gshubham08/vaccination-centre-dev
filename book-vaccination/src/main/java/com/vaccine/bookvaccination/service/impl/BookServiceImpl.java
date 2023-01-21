package com.vaccine.bookvaccination.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vaccine.bookvaccination.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Value("${vaccination-center-api}")
	private String vaccineCenterUrl;
	
	@Autowired
	private RestTemplate restTemplate;

	
	@Override
	public String bookVaccineSlot() {
		
		ResponseEntity<String> vaccineCenter = restTemplate.
				getForEntity(vaccineCenterUrl, String.class);
		
		return vaccineCenter.getBody();
	}

}
