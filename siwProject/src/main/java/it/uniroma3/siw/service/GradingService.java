package it.uniroma3.siw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.User;
import it.uniroma3.siw.model.Grading;
import it.uniroma3.siw.model.Recipe;
import it.uniroma3.siw.repository.GradingRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class GradingService {

	@Autowired GradingRepository gradingRepository;
	@Autowired RecipeService recipeService;

	public Iterable<Grading> getAllGradingByValue(int value) {
		return this.gradingRepository.findAllByValue(value);
	}

	public Grading getGradingById(Long gradingId) {
		return this.gradingRepository.findById(gradingId).orElse(null);
	}

	public Iterable<Recipe> findRecipesByGradingId(Long gradingId) {
		return this.gradingRepository.findRecipesByGradingId(gradingId);
	}

	public void saveOrUpdateGrading(Recipe recipe, User user, int value) {
		Grading existingGrading = getGradingByRecipeAndUser(recipe, user);

		if (existingGrading != null) {
			existingGrading.setValue(value);
		} else {
			existingGrading = new Grading(recipe, user, value);
		}

		gradingRepository.save(existingGrading);

	}

	public List<Grading> getGradingByRecipeId(Long recipeID) {
		return this.gradingRepository.findByRecipeId(recipeID);
	}

	public void deleteByRecipeId(Long recipeID) {
		List<Grading> gradings = this.gradingRepository.findByRecipeId(recipeID);
		this.gradingRepository.deleteAll(gradings);
	}

	public void save(Grading newGrading) {
		this.gradingRepository.save(newGrading);
	}

	public Grading getGradingByRecipeAndUser(Recipe recipe, User currentUser) {
		return this.gradingRepository.findByRecipeAndVoter(recipe, currentUser).orElse(null);
	}
}
