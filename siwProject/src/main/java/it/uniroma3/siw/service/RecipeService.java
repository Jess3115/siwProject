package it.uniroma3.siw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Recipe;
import it.uniroma3.siw.model.User;
import it.uniroma3.siw.repository.RecipeRepository;
import it.uniroma3.siw.repository.UserRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    UserRepository userRepository;

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

    public boolean isRecipeSavedByUser(Long recipeId, Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null)
            return false;

        return user.getSavedRecipes().stream()
                .anyMatch(recipe -> recipe.getId().equals(recipeId));
    }

    @Transactional
    public void toggleSaveRecipe(Long recipeId, Long userId) {
        Recipe recipe = recipeRepository.findById(recipeId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);

        if (user != null && recipe != null) {
            if (user.getSavedRecipes().contains(recipe)) {
                // Rimuovi la ricetta dai salvati
                user.getSavedRecipes().remove(recipe);
                recipe.getSavers().remove(user);
            } else {
                // Aggiungi la ricetta ai salvati
                user.getSavedRecipes().add(recipe);
                recipe.getSavers().add(user);
            }

            recipeRepository.save(recipe);
            userRepository.save(user);
        }
    }

}
