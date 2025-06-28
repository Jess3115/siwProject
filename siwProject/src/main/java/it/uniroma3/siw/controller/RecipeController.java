package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.model.Recipe;
import it.uniroma3.siw.service.IngredientService;
import it.uniroma3.siw.service.RecipeCategoryService;
import it.uniroma3.siw.service.RecipeService;

@Controller
public class RecipeController {

    @Autowired RecipeService recipeService;
	@Autowired RecipeCategoryService categoryService;
	@Autowired IngredientService ingredientService;

    @GetMapping("/recipe")
    public String showRecipes(Model model) {
        model.addAttribute("recipes", recipeService.getAllRecipes());
        return "recipes.html";
    }

    @GetMapping("/recipe/{recipeID}")
    public String getRecipe(@PathVariable Long recipeID, @RequestParam(defaultValue = "/recipe") String from, Model model) {
        Recipe recipe = recipeService.getRecipeById(recipeID);
        model.addAttribute("recipe", recipe);
        model.addAttribute("averageRating", recipeService.calculateAverageRating(recipe));
        model.addAttribute("backUrl", from);
        return "recipe.html";
    }

    @GetMapping("/admin/newRecipe")
    public String formNewRecipe(Model model) {
        model.addAttribute("newRecipe", new Recipe());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("ingredients", ingredientService.getAllIngredients());
        return "admin/formNewRecipe.html";
    }

    @PostMapping("/admin/newRecipe")
    public String newRecipe(@ModelAttribute Recipe newRecipe, Model model) {
        recipeService.saveRecipe(newRecipe);
        return "redirect:/recipe/" + newRecipe.getId();
    }

    @PostMapping("/admin/deleteRecipe/{recipeID}")
    public String deleteRecipe(@PathVariable Long recipeID, Model model) {
        recipeService.deleteRecipeById(recipeID);
        return "redirect:/recipe";
    }

    @GetMapping("/admin/editRecipe/{recipeID}")
    public String formEditRecipe(@PathVariable Long recipeID, Model model) {
        model.addAttribute("recipe", recipeService.getRecipeById(recipeID));
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("ingredients", ingredientService.getAllIngredients());
        return "admin/formEditRecipe.html";
    }

    @PostMapping("/admin/editRecipe/{recipeID}")
    public String editRecipe(@PathVariable Long recipeID, @ModelAttribute Recipe recipe, Model model) {
        Recipe existingRecipe = recipeService.getRecipeById(recipeID);
        existingRecipe.setName(recipe.getName());
        // Aggiorna altri campi necessari
        recipeService.saveRecipe(existingRecipe);
        return "redirect:/recipe/" + existingRecipe.getId();
    }
}