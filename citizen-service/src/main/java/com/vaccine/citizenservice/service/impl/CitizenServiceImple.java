package com.vaccine.citizenservice.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vaccine.citizenservice.payload.Response;
import com.vaccine.citizenservice.service.CitizenService;

@Service
public class CitizenServiceImple implements CitizenService{

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${book-vaccination-service}")
	private String bookVaccination;
	
	@Override
	@HystrixCommand(fallbackMethod = "callBookVaccineFallback")
	public Map<String, Object> bookVaccine() {
		
		Map<String, Object> result = new HashMap<>();
		
		ResponseEntity<String> vaccineCenter = restTemplate.
				getForEntity(bookVaccination, String.class);
		if(vaccineCenter.getBody() == null) {
			result.put("status", "failed");
			result.put("error", "Vaccination center not available");
		}
		
		Response response = new Response("112013", vaccineCenter.getBody(), "Jalgaon", "covaxin");
		
		result.put("status", "success");
		result.put("data", response);
		return result;
	}

	public Map<String, Object> callBookVaccineFallback(){	
		Map<String, Object> result = new HashMap<>();
		result.put("status", "failed");
		result.put("error", "vaccination-center service not available");
		return result;
	}
	
}
