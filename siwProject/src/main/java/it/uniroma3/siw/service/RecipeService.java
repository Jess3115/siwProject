package it.uniroma3.siw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Recipe;
import it.uniroma3.siw.repository.RecipeRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RecipeService {

	@Autowired RecipeRepository recipeRepository;

    public Iterable<Recipe> getAllRecipes() {
        return this.recipeRepository.findAll();
    }

    public Recipe getRecipeById(Long recipeID) {
       return this.recipeRepository.findById(recipeID).orElse(null);
    }

	public Double calculateAverageRating(Recipe recipe) {
		return this.recipeRepository.calculateAverageRating(recipe.getId());
	}

    public void saveRecipe(Recipe newRecipe) {
        this.recipeRepository.save(newRecipe);
    }

    public void deleteRecipeById(Long recipeID) {
        this.recipeRepository.deleteById(recipeID);
    }
}
