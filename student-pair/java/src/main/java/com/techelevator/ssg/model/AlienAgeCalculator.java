package com.techelevator.ssg.model;

public class AlienAgeCalculator {

	private String planet;
	private double earthAge;
	private double alienAge;
	
	public AlienAgeCalculator(String planet, double earthAge) {
		this.planet = planet;
		this.earthAge = earthAge;
		this.alienAge = calculateAlienAge();
	
	}
	
	public double calculateAlienAge() {
		double earthAgeInDays = this.earthAge * 365.26;
		
		switch(this.planet) {
		
		case("mercury"): {
			this.alienAge = earthAgeInDays / 87.96;
			break;
		}
		case("venus"): {
			this.alienAge = earthAgeInDays / 224.68;
			break;
		}
		case("mars"): {
			this.alienAge = earthAgeInDays / 686.98;
			break;
		}
		case("jupiter"): {
			this.alienAge = this.earthAge / 11.862;
			break;
		}
		case("saturn"): {
			this.alienAge = this.earthAge / 29.456;
			break;
		}
		case("uranus"): {
			this.alienAge = this.earthAge / 84.07;
			break;
		}
		case("neptune"): {
			this.alienAge = this.earthAge / 164.81;
			break;
		}

		}
		return this.alienAge;
	}

	public double getAlienAge() {
		return alienAge;
	}

	public void setAlienAge(double alienAge) {
		this.alienAge = alienAge;
	}

}
