package it.uniroma3.siw.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Procedure;

public interface ProcedureRepository extends CrudRepository<Procedure, Long> {

}
