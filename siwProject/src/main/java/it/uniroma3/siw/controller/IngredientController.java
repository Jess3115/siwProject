package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.model.Ingredient;
import it.uniroma3.siw.service.IngredientService;
import it.uniroma3.siw.service.RecipeCategoryService;

@Controller
public class IngredientController {

    @Autowired IngredientService ingredientService;
    @Autowired RecipeCategoryService recipeCategoryService;

    @GetMapping("/ingredient-category")
    public String showIngredients(Model model) {
        model.addAttribute("ingredients", ingredientService.getAllIngredients());
        model.addAttribute("categories", this.recipeCategoryService.getAllCategories());
        return "ingredients-categories.html";
    }

    @GetMapping("/ingredient/{ingredientID}")
    public String getIngredient(@PathVariable Long ingredientID, 
                               @RequestParam(defaultValue = "/ingredient") String from, 
                               Model model) {
        model.addAttribute("ingredient", ingredientService.getIngredientById(ingredientID));
        model.addAttribute("recipes", ingredientService.findRecipesByIngredientId(ingredientID));
        model.addAttribute("backUrl", from);
        return "ingredient.html";
    }

    @GetMapping("/admin/newIngredient")
    public String formNewIngredient(Model model) {
        model.addAttribute("newIngredient", new Ingredient());
        return "admin/formNewIngredient.html";
    }

    @PostMapping("/admin/newIngredient")
    public String newIngredient(@ModelAttribute Ingredient newIngredient, Model model) {
        ingredientService.saveIngredient(newIngredient);
        return "redirect:/ingredient/" + newIngredient.getId();
    }

    @PostMapping("/admin/deleteIngredient/{ingredientID}")
    public String deleteIngredient(@PathVariable Long ingredientID, Model model) {
        ingredientService.deleteIngredientById(ingredientID);
        return "redirect:/ingredient";
    }

    @GetMapping("/admin/editIngredient/{ingredientID}")
    public String formEditIngredient(@PathVariable Long ingredientID, Model model) {
        model.addAttribute("ingredient", ingredientService.getIngredientById(ingredientID));
        return "admin/formEditIngredient.html";
    }

    @PostMapping("/admin/editIngredient/{ingredientID}")
    public String editIngredient(@PathVariable Long ingredientID, 
                                @ModelAttribute Ingredient ingredient, 
                                Model model) {
        Ingredient existingIngredient = ingredientService.getIngredientById(ingredientID);
        existingIngredient.setName(ingredient.getName());
        ingredientService.saveIngredient(existingIngredient);
        return "redirect:/ingredient/" + existingIngredient.getId();
    }
}