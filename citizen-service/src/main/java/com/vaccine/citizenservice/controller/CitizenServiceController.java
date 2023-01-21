package com.vaccine.citizenservice.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaccine.citizenservice.service.CitizenService;

@RestController
@RequestMapping("/api/citizen-serice/v1")
public class CitizenServiceController {

	@Autowired
	private CitizenService citizenService;
	
	@GetMapping("test")
	public String test() {
		return "ok";
	}
	
	@GetMapping("/boot-vaccine-slot")
	public Map<String, Object> bookVaccine(){
		return citizenService.bookVaccine();
	}
}
