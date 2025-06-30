package it.uniroma3.siw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw.model.Ingredient;
import it.uniroma3.siw.model.Recipe;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

    @Query("SELECT i.recipes FROM Ingredient i WHERE i.id = :ingredientID")
    Iterable<Recipe> findRecipesByIngredientId(@Param("ingredientID") Long ingredientID);

    List<Ingredient> findByNameContainingIgnoreCase(String name);

}
