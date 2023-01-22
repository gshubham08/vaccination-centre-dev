package com.vaccine.bookvaccination.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vaccine.bookvaccination.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Value("${vaccination-center-api}")
	private String vaccineCenterUrl;
	
	@Autowired
	private RestTemplate restTemplate;

	
	@Override
	@HystrixCommand(fallbackMethod = "callBookVaccineSlot")
	public String bookVaccineSlot() {
		
		ResponseEntity<String> vaccineCenter = restTemplate.
				getForEntity(vaccineCenterUrl, String.class);
		
		return vaccineCenter.getBody();
	}

	public String callBookVaccineSlot() {
		return "vaccination-service not available";
	}
	
}
