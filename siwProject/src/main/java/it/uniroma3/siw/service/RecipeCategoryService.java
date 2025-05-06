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
}
