package it.uniroma3.siw.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.siw.model.Image;
import java.util.List;

@Repository
public interface ImageRepository extends CrudRepository<Image, Long> {
    Optional<Image> findByName(String name);

    List<Image> findByRecipeId(Long recipeId);

}

