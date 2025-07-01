package it.uniroma3.siw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.RecipeIngredient;
import it.uniroma3.siw.repository.RecipeIngredientRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RecipeIngredientService {
    @Autowired
    private RecipeIngredientRepository recipeIngredientRepository;

    public Iterable<RecipeIngredient> getAllRecipeIngredients() {
        return this.recipeIngredientRepository.findAll();
    }

    public RecipeIngredient getRecipeIngredientById(Long id) {
        return this.recipeIngredientRepository.findById(id).orElse(null);
    }

    public void save(RecipeIngredient recipeIngredient) {
        this.recipeIngredientRepository.save(recipeIngredient);
    }

    public void deleteById(Long id) {
        this.recipeIngredientRepository.deleteById(id);
    }

    public void deleteByRecipeId(Long recipeId) {
        recipeIngredientRepository.deleteByRecipeId(recipeId);
    }

    public List<RecipeIngredient> getByIngredientId(Long ingredientID) {
        return this.recipeIngredientRepository.findByIngredientId(ingredientID);
    }
}
