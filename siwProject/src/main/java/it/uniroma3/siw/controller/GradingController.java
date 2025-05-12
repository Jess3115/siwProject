package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.uniroma3.siw.service.GradingService;

@Controller
public class GradingController {

	@Autowired GradingService gradingService;
	
	@GetMapping("/grading")
	public String showGradings() {
		return "gradings.html";
	}

	@GetMapping("/grading/{value}")
	public String showGradingsByValue(@PathVariable("value") int value, Model model) {
		model.addAttribute("gradings", this.gradingService.getAllGradingByValue(value));
		return "gradingsValue.html";
	}
	
	@GetMapping("/grading/{value}/{gradingId}")
	public String getGrading(@PathVariable("value") int value, @PathVariable("gradingId") Long gradingId, Model model) {
		model.addAttribute("grading", this.gradingService.getGradingById(gradingId));
		model.addAttribute("recipes", this.gradingService.findRecipesByGradingId(gradingId));
		return "grading.html";
	}
}