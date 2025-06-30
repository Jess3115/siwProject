package it.uniroma3.siw.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    @Query("SELECT AVG(g.value) FROM Grading g WHERE g.recipe.id = :recipeId")
    Double calculateAverageRating(@Param("recipeId") Long recipeId);

    @Query("SELECT r FROM Recipe r JOIN r.gradings g GROUP BY r.id ORDER BY AVG(g.value) DESC")
    List<Recipe> findTopRatedRecipes(Pageable pageable);

    @Query("SELECT r FROM Recipe r WHERE LOWER(r.name) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Recipe> searchRecipes(@Param("query") String query);

    List<Recipe> findTop5ByOrderByIdDesc();


}
