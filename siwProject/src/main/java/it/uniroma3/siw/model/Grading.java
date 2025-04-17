package it.uniroma3.siw.model;

import jakarta.persistence.*;

@Entity
public class Grading {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
}
