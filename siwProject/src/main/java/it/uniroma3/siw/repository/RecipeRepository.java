package it.uniroma3.siw.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    @Query("SELECT AVG(g.value) FROM Grading g WHERE g.recipe.id = :recipeId")
    Double calculateAverageRating(@Param("recipeId") Long recipeId);

}
