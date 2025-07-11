package it.uniroma3.siw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.uniroma3.siw.model.Grading;
import it.uniroma3.siw.model.Image;
import it.uniroma3.siw.model.Ingredient;
import it.uniroma3.siw.model.ProcedureStep;
import it.uniroma3.siw.model.Recipe;
import it.uniroma3.siw.model.RecipeCategory;
import it.uniroma3.siw.model.RecipeIngredient;
import it.uniroma3.siw.model.User;
import it.uniroma3.siw.service.CredentialsService;
import it.uniroma3.siw.service.GradingService;
import it.uniroma3.siw.service.ImageService;
import it.uniroma3.siw.service.IngredientService;
import it.uniroma3.siw.service.ProcedureService;
import it.uniroma3.siw.service.RecipeCategoryService;
import it.uniroma3.siw.service.RecipeIngredientService;
import it.uniroma3.siw.service.RecipeService;
import it.uniroma3.siw.utils.SecurityUtils;

@Controller
public class RecipeController {

    @Autowired RecipeService recipeService;
    @Autowired RecipeCategoryService categoryService;
    @Autowired IngredientService ingredientService;
    @Autowired ImageService imageService;
    @Autowired GradingService gradingService;
    @Autowired ProcedureService procedureService;
    @Autowired RecipeIngredientService recipeIngredientService;
    @Autowired SecurityUtils securityUtils;
    @Autowired CredentialsService credentialsService;

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

        // Recupera il voto dell'utente corrente se esiste
        if (securityUtils.isAuthenticated()) {
            User currentUser = securityUtils.getCurrentCredentials(credentialsService).getUser();
            Grading userGrading = gradingService.getGradingByRecipeAndUser(recipe, currentUser);
            model.addAttribute("userGrading", userGrading != null ? userGrading.getValue() : 0);
            boolean isSaved = recipeService.isRecipeSavedByUser(recipeID, currentUser.getId());
        model.addAttribute("isSaved", isSaved);
        }

        return "recipe.html";
    }

    @PostMapping("/default/recipe/{recipeId}/rate")
    public String rateRecipe(
            @PathVariable Long recipeId,
            @RequestParam("rating") int ratingValue,
            RedirectAttributes redirectAttributes) {

        if (!securityUtils.isAuthenticated()) {
            return "redirect:/login";
        }

        User currentUser = securityUtils.getCurrentCredentials(credentialsService).getUser();
        Recipe recipe = recipeService.getRecipeById(recipeId);

        // Salva o aggiorna il voto
        gradingService.saveOrUpdateGrading(recipe, currentUser, ratingValue);

        return "redirect:/recipe/" + recipeId;
    }

    @PostMapping("/user/saveRecipe/{recipeId}")
public String toggleSaveRecipe(@PathVariable Long recipeId) {
    User currentUser = securityUtils.getCurrentCredentials(credentialsService).getUser();
    recipeService.toggleSaveRecipe(recipeId, currentUser.getId());
    return "redirect:/recipe/" + recipeId;
}

    /*
     * FORM CREAZIONE RICETTA
     */
    @GetMapping("/default/newRecipe/building")
    public String formNewRecipe(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "authenticated/formNewRecipeStep1.html";
    }

    // Aggiungi questi nuovi endpoint al controller
    @PostMapping("/default/newRecipe/building")
    public String saveBasicRecipe(
            @RequestParam("name") String name,
            @RequestParam(value = "categories", required = false) List<Long> categoryIds) {

        Recipe recipe = new Recipe();
        recipe.setName(name);

        // Imposta l'utente corrente come creatore
        User currentUser = securityUtils.getCurrentCredentials(credentialsService).getUser();
        recipe.setCreator(currentUser);
        currentUser.getCreatedRecipes().add(recipe);

        recipeService.saveRecipe(recipe);

        // Aggiungi categorie
        if (categoryIds != null && !categoryIds.isEmpty()) {
            List<RecipeCategory> categories = new ArrayList<>();
            for (Long categoryId : categoryIds) {
                RecipeCategory category = categoryService.getCategoryById(categoryId);
                categories.add(category);
                category.getRecipes().add(recipe);
                categoryService.saveCategory(category);
            }
            recipe.setCategories(categories);
            recipeService.saveRecipe(recipe);
        }

        return "redirect:/default/newRecipe/building/addIngredient/" + recipe.getId();
    }

    @GetMapping("/default/newRecipe/building/addIngredient/{recipeId}")
    public String formAddIngredients(@PathVariable Long recipeId, Model model) {
        model.addAttribute("recipeId", recipeId);
        model.addAttribute("ingredients", ingredientService.getAllIngredients());
        return "authenticated/formNewRecipeStep2.html";
    }

    @PostMapping("/default/newRecipe/building/addIngredient/{recipeId}")
    public String addIngredientsToRecipe(
            @PathVariable Long recipeId,
            @RequestParam("ingredientId") List<Long> ingredientIds,
            @RequestParam(value = "newIngredientName", required = false) List<String> newIngredientNames,
            @RequestParam("quantity") List<Double> quantities,
            @RequestParam("unit") List<String> units) {

        Recipe recipe = recipeService.getRecipeById(recipeId);

        for (int i = 0; i < ingredientIds.size(); i++) {
            Ingredient ingredient;
            Long ingredientId = ingredientIds.get(i);

            // Se è stato selezionato "Altro..." e fornito un nuovo nome
            if (ingredientId == -1 && newIngredientNames != null && i < newIngredientNames.size()) {
                String newName = newIngredientNames.get(i);
                if (newName != null && !newName.trim().isEmpty()) {
                    // Crea un nuovo ingrediente
                    ingredient = new Ingredient();
                    ingredient.setName(newName.trim());
                    ingredient.setRecipes(new LinkedList<Recipe>());
                    ingredient = ingredientService.saveNewIngredient(ingredient);
                } else {
                    // Salta se non è stato fornito un nome
                    continue;
                }
            } else {
                // Usa l'ingrediente esistente
                ingredient = ingredientService.getIngredientById(ingredientId);
            }

            RecipeIngredient ri = new RecipeIngredient();
            ri.setRecipe(recipe);
            ri.setIngredient(ingredient);
            ri.setQuantity(quantities.get(i));
            ri.setUnit(units.get(i));
            recipeIngredientService.save(ri);

            ingredient.getRecipes().add(recipe);
            ingredientService.saveIngredient(ingredient);
        }

        return "redirect:/default/newRecipe/building/addStep/" + recipeId;
    }

    @GetMapping("/default/newRecipe/building/addStep/{recipeId}")
    public String formAddSteps(@PathVariable Long recipeId, Model model) {
        model.addAttribute("recipeId", recipeId);
        return "authenticated/formNewRecipeStep3.html";
    }

    @PostMapping("/default/newRecipe/building/addStep/{recipeId}")
    public String addStepsToRecipe(
            @PathVariable Long recipeId,
            @RequestParam("stepDescription") List<String> stepDescriptions,
            @RequestParam(value = "stepNote", required = false) List<String> stepNotes) {

        Recipe recipe = recipeService.getRecipeById(recipeId);

        if (stepNotes == null) {
            stepNotes = new ArrayList<>();
        }

        // Aggiungi passaggi
        for (int i = 0; i < stepDescriptions.size(); i++) {
            ProcedureStep step = new ProcedureStep();
            step.setDescription(stepDescriptions.get(i));
            String note = i < stepNotes.size() ? stepNotes.get(i) : null;
            step.setNote(note);
            step.setStep(i + 1);
            step.setRecipe(recipe);
            procedureService.save(step);
        }

        return "redirect:/default/newRecipe/building/addImage/" + recipeId;
    }

    @GetMapping("/default/newRecipe/building/addImage/{recipeId}")
    public String formAddImages(@PathVariable Long recipeId, Model model) {
        model.addAttribute("recipeId", recipeId);
        return "authenticated/formNewRecipeStep4.html";
    }

    @PostMapping("/default/newRecipe/building/addImage/{recipeId}")
    public String addImagesToRecipe(
            @PathVariable Long recipeId,
            @RequestParam("images") MultipartFile[] imageFiles) throws IOException {

        Recipe recipe = recipeService.getRecipeById(recipeId);

        // Salva immagini
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
    /*
     * FINE FORM CREAZIONE RICETTA
     */

    /*
     * ELIMINAZIONE RICETTA
     */

    @PostMapping("/admin/recipe/delete/{recipeID}")
    public String deleteRecipe(@PathVariable Long recipeID, Model model) {
        Recipe recipe = recipeService.getRecipeById(recipeID);

        // 1. Rimuovi gli RecipeIngredient associati
        recipeIngredientService.deleteByRecipeId(recipeID);

        // 2. Rimuovi la ricetta dalle categorie
        for (RecipeCategory category : recipe.getCategories()) {
            category.getRecipes().remove(recipe);
        }
        recipe.getCategories().clear();

        // 3. Rimuovi la ricetta dagli ingredienti
        for (Ingredient ingredient : recipe.getIngredients()) {
            ingredient.getRecipes().remove(recipe);
        }
        recipe.getIngredients().clear();

        // 4. Rimuovi la ricetta dagli utenti che l'hanno salvata
        for (User saver : recipe.getSavers()) {
            saver.getSavedRecipes().remove(recipe);
        }
        recipe.getSavers().clear();

        // 5. Elimina le dipendenze
        imageService.deleteByRecipeId(recipeID);
        gradingService.deleteByRecipeId(recipeID);
        procedureService.deleteByRecipeId(recipeID);

        // 6. Rimuovi gli RecipeIngredient associati
        recipeIngredientService.deleteByRecipeId(recipeID);

        // 7. Elimina la ricetta
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

    @GetMapping("/default/trending")
    public String showTrendingRecipes(Model model) {
        model.addAttribute("topRecipes", recipeService.getTopRatedRecipes());
        model.addAttribute("recipeService", recipeService);
        return "authenticated/trending.html";
    }

    @GetMapping("/default/lastRecipe")
    public String showLastRecipes(Model model) {
        List<Recipe> lastRecipes = recipeService.getLastCreatedRecipes();
        model.addAttribute("recipes", lastRecipes);
        model.addAttribute("images", imageService.getImagesByRecipes(lastRecipes));
        return "authenticated/lastRecipe.html";
    }
}