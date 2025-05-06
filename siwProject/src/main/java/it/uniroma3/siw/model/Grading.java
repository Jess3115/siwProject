package it.uniroma3.siw.model;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Grading {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Min(1)
	@Max(5)
	private int value;
	
	@OneToMany(mappedBy = "grading")
	private List<Recipe> recipes;
}
