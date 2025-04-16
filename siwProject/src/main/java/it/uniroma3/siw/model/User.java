package it.uniroma3.siw.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class User {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	private String firstName;
	private String lastName;
	private ShoppingList shoppingList;
	
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	
	@ManyToMany
	private List<Recipe> otherRecipe;
	
	@OneToMany
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
		return otherRecipe;
	}

	public void setOtherRecipe(List<Recipe> otherRecipe) {
		this.otherRecipe = otherRecipe;
	}

	public List<Recipe> getMyRecipe() {
		return myRecipe;
	}

	public void setMyRecipe(List<Recipe> myRecipe) {
		this.myRecipe = myRecipe;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, myRecipe, otherRecipe, password, shoppingList, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(myRecipe, other.myRecipe) && Objects.equals(otherRecipe, other.otherRecipe)
				&& Objects.equals(password, other.password) && Objects.equals(shoppingList, other.shoppingList)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", shoppingList="
				+ shoppingList + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", otherRecipe=" + otherRecipe + ", myRecipe=" + myRecipe + "]";
	}
}
