package it.uniroma3.siw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Grading;
import it.uniroma3.siw.model.Recipe;
import it.uniroma3.siw.repository.GradingRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class GradingService {
	
	@Autowired GradingRepository gradingRepository;

	public Iterable<Grading> getAllGrading() {
		return this.gradingRepository.findAll();
	}

	public Grading getGradingById(Long gradingId) {
		return this.gradingRepository.findById(gradingId).orElse(null);
	}

	public Iterable<Recipe> findRecipesByGradingId(Long gradingId) {
		return this.gradingRepository.findRecipesByGradingId(gradingId);
	}
	
}
