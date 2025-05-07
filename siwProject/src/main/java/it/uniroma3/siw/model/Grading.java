package it.uniroma3.siw.model;

import java.util.List;
import java.util.Objects;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, recipes, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grading other = (Grading) obj;
		return Objects.equals(id, other.id) && Objects.equals(recipes, other.recipes) && value == other.value;
	}

	@Override
	public String toString() {
		return "Grading [id=" + id + ", value=" + value + ", recipes=" + recipes + "]";
	}
	
	
}
