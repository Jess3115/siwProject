package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.uniroma3.siw.service.RecipeCategoryService;

@Controller
public class RecipeCategoryController {

	@Autowired RecipeCategoryService recipeCategoryService;
	
	@GetMapping("/category")
	public String showCategories(Model model) {
		model.addAttribute("categories", this.recipeCategoryService.getAllCategories());
		return "categories.html";
	}
}
