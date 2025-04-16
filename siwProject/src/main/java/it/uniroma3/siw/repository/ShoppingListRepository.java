package it.uniroma3.siw.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.ShoppingList;

public interface ShoppingListRepository extends CrudRepository<ShoppingList, Long> {

}
