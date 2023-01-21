package com.citizen.center.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CitizenServiceController {

	@GetMapping("/test")
	public String test() {
		return "OK";
	}
	
	@GetMapping("/getvalue")
	public String test2() {
		return "value";
	}
	
}
