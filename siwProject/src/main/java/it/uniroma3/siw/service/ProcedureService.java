package it.uniroma3.siw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.ProcedureStep;
import it.uniroma3.siw.repository.ProcedureRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProcedureService {

	@Autowired ProcedureRepository procedureRepository;

	List<ProcedureStep> getProcedureByRecipeId(Long recipeID) {
		return this.procedureRepository.findByRecipeId(recipeID);
	}

    public void deleteByRecipeId(Long recipeID) {
        List<ProcedureStep> procedures = this.procedureRepository.findByRecipeId(recipeID);
        this.procedureRepository.deleteAll(procedures);
    }

    public void save(ProcedureStep step) {
        this.procedureRepository.save(step);
    }
}
