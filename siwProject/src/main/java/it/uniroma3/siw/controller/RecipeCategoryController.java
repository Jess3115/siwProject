package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.uniroma3.siw.model.RecipeCategory;
import it.uniroma3.siw.service.RecipeCategoryService;

@Controller
public class RecipeCategoryController {

	@Autowired RecipeCategoryService recipeCategoryService;
	
	@GetMapping("/category")
	public String showCategories(Model model) {
		model.addAttribute("categories", this.recipeCategoryService.getAllCategories());
		return "categories.html";
	}
	
	@GetMapping("/category/{categoryID}")
	public String getCategory(@PathVariable("categoryID") Long categoryID, Model model) {
		model.addAttribute("category", this.recipeCategoryService.getCategoryById(categoryID));
		model.addAttribute("recipes", this.recipeCategoryService.findRecipesByCategoryId(categoryID));
		return "category.html";
	}
}
