package com.vaccine.citizenservice.payload;

import java.time.LocalDateTime;

public class Response {

	private String centerCode;
	
	private String center;
	
	private LocalDateTime dateAndTime;
	
	private String location;
	
	private String vaccine;
	
	public Response(String centerCode, String center, String location, String vaccine) {
		super();
		this.centerCode = centerCode;
		this.center = center;
		this.dateAndTime = LocalDateTime.now();
		this.location = location;
		this.vaccine = vaccine;
	}

	public String getCenterCode() {
		return centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime() {
		this.dateAndTime = LocalDateTime.now();
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getVaccine() {
		return vaccine;
	}

	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}
		
}

