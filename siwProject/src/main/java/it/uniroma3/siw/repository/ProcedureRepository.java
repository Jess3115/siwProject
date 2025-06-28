package it.uniroma3.siw.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.ProcedureStep;

public interface ProcedureRepository extends CrudRepository<ProcedureStep, Long> {

}
