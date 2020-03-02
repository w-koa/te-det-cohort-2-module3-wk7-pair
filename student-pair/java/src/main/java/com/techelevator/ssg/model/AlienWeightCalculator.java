package com.techelevator.ssg.model;

public class AlienWeightCalculator {

	private String planet;
	private double earthWeight;
	private double alienWeight;

	public AlienWeightCalculator(String planet, double earthWeight) {
		this.planet = planet;
		this.earthWeight = earthWeight;
		this.alienWeight = calculateAlienWeight();

	}

	public double calculateAlienWeight() {

		
		switch (this.planet) {

		case ("mercury"): {
			this.alienWeight = this.earthWeight * 0.37;
			break;
		}
		case ("venus"): {
			this.alienWeight = this.earthWeight * 0.9;
			break;
		}
		case ("mars"): {
			this.alienWeight = this.earthWeight * 0.38;
			break;
		}
		case ("jupiter"): {
			this.alienWeight = this.earthWeight * 2.65;
			break;
		}
		case ("saturn"): {
			this.alienWeight = this.earthWeight * 1.13;
			break;
		}
		case ("uranus"): {
			this.alienWeight = this.earthWeight * 1.09;
			break;
		}
		case ("neptune"): {
			this.alienWeight = this.earthWeight * 1.43;
			break;
		}

		}
		return this.alienWeight;

	}

	public double getAlienWeight() {
		return alienWeight;
	}

	public void setAlienWeight(double alienWeight) {
		this.alienWeight = alienWeight;
	}

}
