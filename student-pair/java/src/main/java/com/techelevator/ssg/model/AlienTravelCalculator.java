package com.techelevator.ssg.model;

public class AlienTravelCalculator {
	
	private String planet;
	private double earthAge;
	private String transportType;
	private double travelTimeResult;
	private double ageResult;
	
	public AlienTravelCalculator(String planet, String transportType, double earthAge) {
		
		
		
	}

	
	
	
	// Getters and Setters
	public double getTravelTimeResult() {
		return travelTimeResult;
	}

	public void setTravelTimeResult(double travelTimeResult) {
		this.travelTimeResult = travelTimeResult;
	}

	public double getAgeResult() {
		return ageResult;
	}

	public void setAgeResult(double ageResult) {
		this.ageResult = ageResult;
	}

}
