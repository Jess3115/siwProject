package it.uniroma3.siw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
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

    public List<Recipe> getTopRatedRecipes() {
        Pageable top10 = PageRequest.of(0, 10);
        return this.recipeRepository.findTopRatedRecipes(top10);
    }

    public List<Recipe> searchRecipes(String query) {
        return this.recipeRepository.searchRecipes(query);
    }
}
