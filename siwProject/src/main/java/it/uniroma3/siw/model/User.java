package it.uniroma3.siw.model;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String name;
	@NotBlank
	private String surname;
	@NotNull
	@PastOrPresent
	private Date dateOfBirth;

	@NotNull
	@Email
	private String email;

	@OneToMany(mappedBy = "voter")
	private List<Grading> gradings;

	@ManyToMany
	private List<Recipe> savedRecipes;

	@OneToMany(mappedBy = "creator")
	private List<Recipe> createdRecipes;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<Grading> getGradings() {
		return gradings;
	}

	public void setGradings(List<Grading> gradings) {
		this.gradings = gradings;
	}

	public List<Recipe> getSavedRecipes() {
		return savedRecipes;
	}

	public void setSavedRecipes(List<Recipe> savedRecipes) {
		this.savedRecipes = savedRecipes;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return name;
	}

	public void setFirstName(String firstName) {
		this.name = firstName;
	}

	public String getLastName() {
		return surname;
	}

	public void setLastName(String lastName) {
		this.surname = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Recipe> getOtherRecipe() {
		return savedRecipes;
	}

	public void setOtherRecipe(List<Recipe> otherRecipe) {
		this.savedRecipes = otherRecipe;
	}

	public List<Recipe> getMyRecipe() {
		return createdRecipes;
	}

	public void setMyRecipe(List<Recipe> createdRecipes) {
		this.createdRecipes = createdRecipes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id) &&
				Objects.equals(email, other.email);
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
