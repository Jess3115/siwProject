package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.model.RecipeCategory;
import it.uniroma3.siw.service.RecipeCategoryService;

@Controller
public class RecipeCategoryController {

	@Autowired
	RecipeCategoryService recipeCategoryService;

	@GetMapping("/category/{categoryID}")
	public String getCategory(
			@PathVariable Long categoryID,
			@RequestParam(defaultValue = "/ingredient-category") String from,
			Model model) {
		model.addAttribute("category", this.recipeCategoryService.getCategoryById(categoryID));
		model.addAttribute("recipes", this.recipeCategoryService.findRecipesByCategoryId(categoryID));
		model.addAttribute("backUrl", from);
		return "category.html";
	}

	@GetMapping("/admin/newCategory")
	public String formNewCategory(Model model) {
		model.addAttribute("newCategory", new RecipeCategory());
		return "admin/formNewCategory.html";
	}

	@PostMapping("/admin/newCategory")
	public String newCategory(@ModelAttribute RecipeCategory newCategory, Model model) {
		this.recipeCategoryService.save(newCategory);
		model.addAttribute("categories", this.recipeCategoryService.getAllCategories());
		return "redirect:/category/" + newCategory.getId();
	}

	// da controllare eliminazione bidirezionale
	@PostMapping("/admin/deleteCategory/{categoryID}")
	public String deleteCategory(@PathVariable Long categoryID, Model model) {
		this.recipeCategoryService.deleteCategoryById(categoryID);
		model.addAttribute("categories", this.recipeCategoryService.getAllCategories());
		return "redirect:/ingredient-category";
	}

	@GetMapping("/admin/editCategory/{categoryID}")
	public String formEditCategory(@PathVariable Long categoryID, Model model) {
		model.addAttribute("category", this.recipeCategoryService.getCategoryById(categoryID));
		return "admin/formEditCategory.html";

	}

	@PostMapping("/admin/editCategory/{categoryID}")
	public String editCategory(
			@PathVariable Long categoryID,
			@ModelAttribute RecipeCategory updatedCategory
			) {
		RecipeCategory existingCategory = recipeCategoryService.getCategoryById(categoryID);
		existingCategory.setName(updatedCategory.getName());
		recipeCategoryService.save(existingCategory);
		return "redirect:/category/" + categoryID;
	}
}
