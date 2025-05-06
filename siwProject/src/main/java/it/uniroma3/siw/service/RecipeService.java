package it.uniroma3.siw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.repository.RecipeRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RecipeService {

	@Autowired RecipeRepository recipeRepository;
}
