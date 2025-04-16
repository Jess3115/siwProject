package it.uniroma3.siw.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.RecipeCategory;

public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory, Long> {
	
}
