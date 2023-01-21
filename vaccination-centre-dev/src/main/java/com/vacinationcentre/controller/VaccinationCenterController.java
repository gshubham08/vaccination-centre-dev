package com.vacinationcentre.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vaccine-service/v1")
public class VaccinationCenterController {

	@GetMapping("/test")
	public String test() {
		return "OK";
	}
	
	@GetMapping("/get-center")
	public String getCenter() {
		return "Nanibai Hospital";
	}
}
///api/vaccine-service/v1/get-center