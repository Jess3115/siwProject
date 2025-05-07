package it.uniroma3.siw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.RecipeCategory;
import it.uniroma3.siw.repository.RecipeCategoryRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RecipeCategoryService {

	@Autowired RecipeCategoryRepository recipeCategoryRepository;

	public Iterable<RecipeCategory> getAllCategories() {
		return this.recipeCategoryRepository.findAll();
	}

	public RecipeCategory getCategoryById(Long id) {
		return this.recipeCategoryRepository.findById(id).orElse(null);
	}

	public void save(RecipeCategory recipeCategory) {
		this.recipeCategoryRepository.save(recipeCategory);
	}
}
