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
	private EndUser creator;
	
	@ManyToMany
	private List<EndUser> savers;
	
	@ManyToOne
	private Grading grading;
	
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

	public EndUser getCreator() {
		return creator;
	}

	public void setCreator(EndUser creator) {
		this.creator = creator;
	}

	public List<EndUser> getSavers() {
		return savers;
	}

	public void setSavers(List<EndUser> savers) {
		this.savers = savers;
	}

	public Grading getGrading() {
		return grading;
	}

	public void setGrading(Grading grading) {
		this.grading = grading;
	}

	public List<RecipeCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<RecipeCategory> categories) {
		this.categories = categories;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categories, creator, grading, id, name, savers);
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
				&& Objects.equals(grading, other.grading) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(savers, other.savers);
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", creator=" + creator + ", savers=" + savers + ", grading="
				+ grading + ", categories=" + categories + "]";
	}
	
	

}
