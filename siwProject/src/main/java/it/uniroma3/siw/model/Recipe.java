package it.uniroma3.siw.model;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String name;

	@ManyToOne(optional = false)
	private User creator;

	@ManyToMany(mappedBy = "savedRecipes")
	private Set<User> savers;

	@OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Grading> gradings;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "recipes")
	private List<RecipeCategory> categories;

	@OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Image> images;

	@OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<ProcedureStep> procedures;

	@ManyToMany(mappedBy = "recipes", fetch = FetchType.LAZY)
	private List<Ingredient> ingredients;

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

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Recipe recipe = (Recipe) o;
		return Objects.equals(id, recipe.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Recipe{id=" + id + ", name='" + name + "'}";
	}

    public void addImage(Image image) {
        this.images.add(image);
    }

}
