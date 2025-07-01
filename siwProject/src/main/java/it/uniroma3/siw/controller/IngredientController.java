package it.uniroma3.siw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.model.Ingredient;
import it.uniroma3.siw.model.RecipeCategory;
import it.uniroma3.siw.service.IngredientService;
import it.uniroma3.siw.service.RecipeCategoryService;

@Controller
public class IngredientController {

    @Autowired
    IngredientService ingredientService;
    @Autowired
    RecipeCategoryService recipeCategoryService;

    @GetMapping("/ingredient-category")
    public String showIngredients(
            @RequestParam(name = "search", required = false) String searchQuery,
            Model model) {

        List<Ingredient> ingredients;
        List<RecipeCategory> categories;

        if (searchQuery != null && !searchQuery.trim().isEmpty()) {
            // Filtra gli ingredienti e le categorie
            ingredients = ingredientService.searchIngredients(searchQuery);
            categories = recipeCategoryService.searchCategories(searchQuery);
        } else {
            // Mostra tutti gli elementi
            ingredients = (List<Ingredient>) ingredientService.getAllIngredients();
            categories = (List<RecipeCategory>) this.recipeCategoryService.getAllCategories();
        }

        model.addAttribute("ingredients", ingredients);
        model.addAttribute("categories", categories);
        model.addAttribute("searchQuery", searchQuery); // Per mantenere il testo nella barra di ricerca
        return "ingredients-categories.html";
    }

    @GetMapping("/ingredient/{ingredientID}")
    public String getIngredient(@PathVariable Long ingredientID,
            @RequestParam(defaultValue = "/ingredient-category") String from,
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
        return "redirect:/ingredient-category";
    }

    @GetMapping("/admin/editIngredient/{ingredientID}")
    public String formEditIngredient(@PathVariable Long ingredientID, Model model) {
        model.addAttribute("ingredient", ingredientService.getIngredientById(ingredientID));
        return "admin/formEditIngredient.html";
    }

    @PostMapping("/admin/editIngredient/{ingredientID}")
    public String editIngredient(
            @PathVariable Long ingredientID,
            @ModelAttribute Ingredient updatedIngredient) {
        Ingredient existingIngredient = ingredientService.getIngredientById(ingredientID);
        existingIngredient.setName(updatedIngredient.getName());
        ingredientService.saveIngredient(existingIngredient);
        return "redirect:/ingredient/" + existingIngredient.getId();
    }
}