package it.uniroma3.siw.model;

import jakarta.persistence.*;

@Entity
public class ShoppingList {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;

}
