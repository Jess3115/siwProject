package it.uniroma3.siw.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw.model.EndUser;
import it.uniroma3.siw.model.Grading;
import it.uniroma3.siw.model.Recipe;

public interface GradingRepository extends CrudRepository<Grading, Long> {

	@Query("SELECT g.recipe FROM Grading g WHERE g.id = :gradingId")
	Iterable<Recipe> findRecipesByGradingId(@Param("gradingId") Long gradingId);
	
    Optional<Grading> findByRecipeAndVoter(Recipe recipe, EndUser voter);

	Iterable<Grading> findAllByValue(int value);

}
