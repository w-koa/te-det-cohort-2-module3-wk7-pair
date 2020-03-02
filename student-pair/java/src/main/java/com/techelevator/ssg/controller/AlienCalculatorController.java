package com.techelevator.ssg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.ssg.model.AlienAgeCalculator;
import com.techelevator.ssg.model.AlienWeightCalculator;

@Controller
public class AlienCalculatorController {	
	
	// Weight Mappings

	@RequestMapping("/alienWeight")
	public String displayAlienWeightPage() {
		return "alienWeight";
	}
	

	@RequestMapping("/alienWeightResults")
	public String showAlienWeightResults(@RequestParam String planet, @RequestParam double earthWeight, ModelMap map) {


		AlienWeightCalculator weightCalculator = new AlienWeightCalculator(planet, earthWeight);
		map.put("weightCalculator", weightCalculator);
		return "alienWeightResults";
	
	}
	
	// Age Mappings
	
	@RequestMapping("/alienAge")
	public String displayAlienAgePage() {
		return "alienAge";
	}
	
	@RequestMapping("/alienAgeResults")
	public String showAlienAgeResults(@RequestParam String planet, @RequestParam double earthAge, ModelMap map) {
		
		AlienAgeCalculator ageCalculator = new AlienAgeCalculator(planet, earthAge);
		map.put("ageCalculator", ageCalculator);
		return "alienAgeResults";
	}
	
	
	
	
	// Travel Time Mappings
	
	@RequestMapping("/driveTime")
	public String displayDriveTimePage() {
		return "driveTime";
		
	}
	
	@RequestMapping("travelTimeResults")
	public String showTravelTimeResults() {

		return "driveTimeResults";
	}
	
	
	
	
}
