package it.uniroma3.siw.model;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class EndUser  {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String name;
	@NotBlank
	private String surname;
	@NotNull
	@PastOrPresent
	private Date dateOfBirth;

	@OneToOne(mappedBy = "owner")
	private ShoppingList shoppingList;

	@NotNull
	@Email
	private String email;
	@NotNull
	private String username;
	@NotNull
	private String password;

	@OneToMany(mappedBy = "voter")
	private List<Grading> gradings;

	@ManyToMany(mappedBy = "savers")
	private List<Recipe> savedRecipes;

	@OneToMany(mappedBy = "creator")
	private List<Recipe> myRecipe;

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

	public ShoppingList getShoppingList() {
		return shoppingList;
	}

	public void setShoppingList(ShoppingList shoppingList) {
		this.shoppingList = shoppingList;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Recipe> getOtherRecipe() {
		return savedRecipes;
	}

	public void setOtherRecipe(List<Recipe> otherRecipe) {
		this.savedRecipes = otherRecipe;
	}

	public List<Recipe> getMyRecipe() {
		return myRecipe;
	}

	public void setMyRecipe(List<Recipe> myRecipe) {
		this.myRecipe = myRecipe;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateOfBirth, email, gradings, id, myRecipe, name, password, savedRecipes, shoppingList,
				surname, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EndUser other = (EndUser) obj;
		return Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(email, other.email)
				&& Objects.equals(gradings, other.gradings) && Objects.equals(id, other.id)
				&& Objects.equals(myRecipe, other.myRecipe) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(savedRecipes, other.savedRecipes)
				&& Objects.equals(shoppingList, other.shoppingList) && Objects.equals(surname, other.surname)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "EndUser [id=" + id + ", name=" + name + ", surname=" + surname + ", dateOfBirth=" + dateOfBirth
				+ ", shoppingList=" + shoppingList + ", email=" + email + ", username=" + username + ", password="
				+ password + ", gradings=" + gradings + ", savedRecipes=" + savedRecipes + ", myRecipe=" + myRecipe
				+ "]";
	}
}
