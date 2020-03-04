package com.techelevator.ssg.model;

public class AlienTravelCalculator {
	
	private String planet;
	private double earthAge;
	private String transportType;
	private double travelTimeResult;
	private double ageResult;
	
	public AlienTravelCalculator(String planet, String transportType, double earthAge) {
		this.planet = planet;
		this.transportType = transportType;
		this.earthAge = earthAge;		
		this.travelTimeResult = calculateTravelTime();
		this.ageResult = calculateAgeResult();
	}

	public double calculateTravelTime() {
		double travelTimeResult = 0;
		double travelRate = 0;
		
		switch(transportType) {
		
		case("Walking"): {
			travelRate = 3;
		}
		case("Car"): {
			travelRate = 100;
		}
		case("Bullet Train"): {
			travelRate = 200;
		}
		case("Boeing 747"): {
			travelRate = 570;
		}
		case("Concord"): {
			travelRate = 1350;
		}
		}
		
		switch(planet) {
		case("mercury"): {
			travelTimeResult = 56974146 / travelRate / 24 / 365; 
		}
		case("venus"): {
			travelTimeResult = 	25724767 / travelRate / 24 / 365; 
		}
		case("mars"): {
			travelTimeResult = 	48678219 / travelRate / 24 / 365; 
		}
		case("jupiter"): {
			travelTimeResult = 	390674710 / travelRate / 24 / 365; 
		}
		case("saturn"): {
			travelTimeResult = 	792248270 / travelRate / 24 / 365; 
		}
		case("uranus"): {
			travelTimeResult = 	1692662530 / travelRate / 24 / 365; 
		}
		case("neptune"): {
			travelTimeResult = 	((long)2703959960L) / travelRate / 24 / 365; 
		}
		}
		return travelTimeResult;
	}
	
	public double calculateAgeResult() {
		this.ageResult = earthAge + calculateTravelTime();
		return ageResult;
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
