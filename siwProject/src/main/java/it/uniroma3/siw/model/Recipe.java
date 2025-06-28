package it.uniroma3.siw.model;

import java.util.List;
import java.util.Objects;
import java.util.Set;

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
	private Set<User> savers;
	
	@OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true) //orphanRemoval to delete gradings when is removed from the collection
	private List<Grading> gradings;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "recipes")
	private List<RecipeCategory> categories;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Image> images;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<ProcedureStep> procedures;

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

	public Set<User> getSavers() {
		return savers;
	}

	public void setSavers(Set<User> savers) {
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

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Set<ProcedureStep> getProcedures() {
		return procedures;
	}

	public void setProcedures(Set<ProcedureStep> procedures) {
		this.procedures = procedures;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Recipe)) return false;
		Recipe recipe = (Recipe) o;
		return id.equals(recipe.id) &&
				name.equals(recipe.name) &&
				Objects.equals(creator, recipe.creator) &&
				Objects.equals(savers, recipe.savers) &&
				Objects.equals(gradings, recipe.gradings) &&
				Objects.equals(categories, recipe.categories) &&
				Objects.equals(images, recipe.images) &&
				Objects.equals(procedures, recipe.procedures);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public String toString() {	
		return "Recipe{" +
				"id=" + id +
				", name='" + name + '\'' +
				", creator=" + creator +
				", gradings=" + gradings +
				", categories=" + categories +
				'}';
	}
	
	

}
