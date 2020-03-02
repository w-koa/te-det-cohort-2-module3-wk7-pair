package com.techelevator.ssg.model;

public class AlienAgeCalculator {

	private String planet;
	private double age;
	
	public AlienAgeCalculator(String planet, double age) {
		this.planet = planet;
		this.age = age;
		
	
	}
	
	public double calculateAlienAge() {
		double earthAgeInDays = age * 365.26;
		double alienAge = 0;
		switch(planet) {
		
		case("Mercury"): {
			alienAge = earthAgeInDays / 87.96;
		}
		case("Venus"): {
			alienAge = earthAgeInDays / 224.68;
		}
		case("Mars"): {
			alienAge = earthAgeInDays / 686.98;
		}
		case("Jupiter"): {
			alienAge = age / 11.862;
		}
		case("Saturn"): {
			alienAge = age / 29.456;
		}
		case("Uranus"): {
			alienAge = age / 84.07;
		}
		case("Neptune"): {
			alienAge = age / 164.81;
		}

		}
		return alienAge;
	}

}
