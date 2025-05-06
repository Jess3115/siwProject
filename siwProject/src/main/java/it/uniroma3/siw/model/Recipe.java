package it.uniroma3.siw.model;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
public class Recipe {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String name;

	@ManyToOne
	private EndUser creator;
	
	@ManyToMany
	private List<EndUser> savers;
	
	@ManyToOne
	private Grading grading;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "recipes")
	private List<RecipeCategory> categories;



}
