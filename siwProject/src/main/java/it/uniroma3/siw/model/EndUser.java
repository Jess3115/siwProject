package it.uniroma3.siw.model;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "app_user")
public class EndUser  {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@NotNull
	@PastOrPresent
	private Date dateOfBirth;
	
	@OneToOne(mappedBy = "owner")
	private ShoppingList shoppingList;
	
	@NotNull
	private String email;
	@NotNull
	private String username;
	@NotNull
	private String password;
	
	@ManyToMany(mappedBy = "savers")
	private List<Recipe> savedRecipes;
	
	@OneToMany(mappedBy = "creator")
	private List<Recipe> myRecipe;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
		return Objects.hash(email, firstName, id, lastName, myRecipe, savedRecipes, password, shoppingList, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EndUser  other = (EndUser ) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(myRecipe, other.myRecipe) && Objects.equals(savedRecipes, other.savedRecipes)
				&& Objects.equals(password, other.password) && Objects.equals(shoppingList, other.shoppingList)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", shoppingList="
				+ shoppingList + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", otherRecipe=" + savedRecipes + ", myRecipe=" + myRecipe + "]";
	}
}
