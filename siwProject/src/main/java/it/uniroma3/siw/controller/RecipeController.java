package it.uniroma3.siw.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import it.uniroma3.siw.model.Image;
import it.uniroma3.siw.model.Ingredient;
import it.uniroma3.siw.model.ProcedureStep;
import it.uniroma3.siw.model.Recipe;
import it.uniroma3.siw.model.RecipeCategory;
import it.uniroma3.siw.model.RecipeIngredient;
import it.uniroma3.siw.model.User;
import it.uniroma3.siw.service.GradingService;
import it.uniroma3.siw.service.ImageService;
import it.uniroma3.siw.service.IngredientService;
import it.uniroma3.siw.service.ProcedureService;
import it.uniroma3.siw.service.RecipeCategoryService;
import it.uniroma3.siw.service.RecipeIngredientService;
import it.uniroma3.siw.service.RecipeService;

@Controller
public class RecipeController {

    @Autowired
    RecipeService recipeService;
    @Autowired
    RecipeCategoryService categoryService;
    @Autowired
    IngredientService ingredientService;
    @Autowired
    ImageService imageService;
    @Autowired
    GradingService gradingService;
    @Autowired
    ProcedureService procedureService;
    @Autowired
    RecipeIngredientService recipeIngredientService;

    @GetMapping("/recipe")
    public String showRecipes(Model model) {
        model.addAttribute("recipes", recipeService.getAllRecipes());
        model.addAttribute("images", imageService.getAllImages());
        return "recipes.html";
    }

    @GetMapping("/recipe/{recipeID}")
    public String getRecipe(@PathVariable Long recipeID, @RequestParam(defaultValue = "/recipe") String from,
            Model model) {
        Recipe recipe = recipeService.getRecipeById(recipeID);
        model.addAttribute("recipe", recipe);
        model.addAttribute("averageRating", recipeService.calculateAverageRating(recipe));
        model.addAttribute("backUrl", from);
        model.addAttribute("images", imageService.getImagesByRecipeId(recipeID));
        return "recipe.html";
    }

    @GetMapping("/default/newRecipe")
    public String formNewRecipe(Model model) {
        model.addAttribute("newRecipe", new Recipe());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("ingredients", ingredientService.getAllIngredients());
        return "authenticated/formNewRecipe.html";
    }

    @PostMapping("/default/newRecipe")
    public String newRecipe(
        @RequestParam("name") String name,
        @RequestParam(value = "categories", required = false) List<Long> categoryIds,
        @RequestParam("ingredientId") List<Long> ingredientIds,
        @RequestParam("quantity") List<Double> quantities,
        @RequestParam("unit") List<String> units,
        @RequestParam("stepDescription") List<String> stepDescriptions,
        @RequestParam("stepNote") List<String> stepNotes,
        @RequestParam("images") List<MultipartFile> imageFiles,
        Model model) throws IOException {

        // 1. Crea la ricetta base
        Recipe recipe = new Recipe();
        recipe.setName(name);
        recipeService.saveRecipe(recipe);

        // 2. Aggiungi categorie
        if (categoryIds != null) {
            for (Long categoryId : categoryIds) {
                RecipeCategory category = categoryService.getCategoryById(categoryId);
                recipe.getCategories().add(category);
                category.getRecipes().add(recipe);
                categoryService.saveCategory(category);
            }
        }

        // 3. Aggiungi ingredienti con quantità
        for (int i = 0; i < ingredientIds.size(); i++) {
            Ingredient ingredient = ingredientService.getIngredientById(ingredientIds.get(i));
            
            RecipeIngredient ri = new RecipeIngredient();
            ri.setRecipe(recipe);
            ri.setIngredient(ingredient);
            ri.setQuantity(quantities.get(i));
            ri.setUnit(units.get(i));
            
            // Servizio per salvare RecipeIngredient (da implementare)
            recipeIngredientService.save(ri);
            
            // Collega ingrediente alla ricetta
            recipe.getIngredients().add(ingredient);
            ingredient.getRecipes().add(recipe);
            ingredientService.saveIngredient(ingredient);
        }

        // 4. Aggiungi passaggi del procedimento
        for (int i = 0; i < stepDescriptions.size(); i++) {
            ProcedureStep step = new ProcedureStep();
            step.setDescription(stepDescriptions.get(i));
            step.setNote(stepNotes.get(i));
            step.setStep(i + 1);
            step.setRecipe(recipe);
            procedureService.save(step);
        }

        // 5. Salva immagini
        for (MultipartFile file : imageFiles) {
            if (!file.isEmpty()) {
                Image image = new Image();
                image.setName(file.getOriginalFilename());
                image.setData(file.getBytes());
                image.setRecipe(recipe);
                imageService.save(image);
            }
        }

        return "redirect:/recipe/" + recipe.getId();
    }

    @PostMapping("/admin/recipe/delete/{recipeID}")
    public String deleteRecipe(@PathVariable Long recipeID, Model model) {
        // 1. Rimuovi la ricetta dalle categorie
        Recipe recipe = recipeService.getRecipeById(recipeID);
        for (RecipeCategory category : recipe.getCategories()) {
            category.getRecipes().remove(recipe);
        }
        recipe.getCategories().clear();

        // 2. Rimuovi la ricetta dagli ingredienti
        for (Ingredient ingredient : recipe.getIngredients()) {
            ingredient.getRecipes().remove(recipe);
        }
        recipe.getIngredients().clear();

        // 3. Rimuovi la ricetta dagli utenti che l'hanno salvata
        for (User saver : recipe.getSavers()) {
            saver.getSavedRecipes().remove(recipe);
        }
        recipe.getSavers().clear();

        // 4. Elimina le dipendenze
        imageService.deleteByRecipeId(recipeID);
        gradingService.deleteByRecipeId(recipeID);
        procedureService.deleteByRecipeId(recipeID);

        // 5. Elimina la ricetta
        recipeService.deleteRecipeById(recipeID);
        return "redirect:/recipe";
    }

    @GetMapping("/admin/recipe/edit/{recipeID}")
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

    @GetMapping("/trending")
    public String showTrendingRecipes(Model model) {
        model.addAttribute("topRecipes", recipeService.getTopRatedRecipes());
        model.addAttribute("recipeService", recipeService);
        return "authenticated/trending.html";
    }

    @GetMapping("/search")
    public String searchRecipes(
            @RequestParam(value = "query", required = false) String query,
            Model model) {

        if (query != null && !query.trim().isEmpty()) {
            model.addAttribute("results", recipeService.searchRecipes(query));
        }

        model.addAttribute("query", query);
        model.addAttribute("recipeService", recipeService);
        return "authenticated/search.html";
    }
}