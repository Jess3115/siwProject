package it.uniroma3.siw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Ingredient;
import it.uniroma3.siw.model.Recipe;
import it.uniroma3.siw.repository.IngredientRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class IngredientService {

	@Autowired IngredientRepository ingredientRepository;

    public Iterable<Ingredient> getAllIngredients() {
        return this.ingredientRepository.findAll();
    }

    public Iterable<Recipe> findRecipesByIngredientId(Long ingredientID) {
        return this.ingredientRepository.findRecipesByIngredientId(ingredientID);
    }

    public Ingredient getIngredientById(Long ingredientID) {
        return this.ingredientRepository.findById(ingredientID).orElse(null);
    }

    public void saveIngredient(Ingredient newIngredient) {
        this.ingredientRepository.save(newIngredient);
    }

    public Ingredient saveNewIngredient(Ingredient ingredient) {
        return this.ingredientRepository.save(ingredient);
    }

    public void deleteIngredientById(Long ingredientID) {
        this.ingredientRepository.deleteById(ingredientID);
    }

    public List<Ingredient> searchIngredients(String query) {
        return ingredientRepository.findByNameContainingIgnoreCase(query);
    }
}
