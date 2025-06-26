package it.uniroma3.siw.model;

import java.util.List;
import java.util.Objects;

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
	private User creator;
	
	@ManyToMany
	private List<User> savers;
	
	@OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Grading> gradings;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "recipes")
	private List<RecipeCategory> categories;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public List<User> getSavers() {
		return savers;
	}

	public void setSavers(List<User> savers) {
		this.savers = savers;
	}

	public List<Grading> getGradings() {
		return gradings;
	}

	public void setGradings(List<Grading> gradings) {
		this.gradings = gradings;
	}

	public List<RecipeCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<RecipeCategory> categories) {
		this.categories = categories;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categories, creator, gradings, id, name, savers);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recipe other = (Recipe) obj;
		return Objects.equals(categories, other.categories) && Objects.equals(creator, other.creator)
				&& Objects.equals(gradings, other.gradings) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(savers, other.savers);
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", creator=" + creator + ", savers=" + savers + ", grading="
				+ gradings + ", categories=" + categories + "]";
	}
	
	

}
