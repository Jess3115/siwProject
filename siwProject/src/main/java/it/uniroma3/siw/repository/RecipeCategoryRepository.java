package it.uniroma3.siw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw.model.Recipe;
import it.uniroma3.siw.model.RecipeCategory;

public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory, Long> {

	@Query("SELECT c.recipes FROM RecipeCategory c WHERE c.id = :categoryID")
	Iterable<Recipe> findRecipesByCategoryId(@Param("categoryID") Long categoryID);

    List<RecipeCategory> findByNameContainingIgnoreCase(String name);

	
}
