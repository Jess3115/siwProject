package it.uniroma3.siw.repository;

import it.uniroma3.siw.model.RecipeIngredient;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, Long> {

    @Modifying
    @Query("DELETE FROM RecipeIngredient ri WHERE ri.recipe.id = :recipeId")
    void deleteByRecipeId(@Param("recipeId") Long recipeId);

    List<RecipeIngredient> findByIngredientId(Long ingredientID);

}
