package it.uniroma3.siw.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Ingredient {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	private String name; // Nome dell'ingrediente

	private double quantity; // Quantità dell'ingrediente

	private String unit; // Unità di misura (es. grammi, litri, cucchiai)

	private List<Recipe> recipes; // Ricette che utilizzano questo ingrediente

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

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Ingredient)) return false;
		Ingredient that = (Ingredient) o;
		return Double.compare(that.quantity, quantity) == 0 &&
				id.equals(that.id) &&
				name.equals(that.name) &&
				unit.equals(that.unit);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, quantity, unit);
	}

	@Override
	public String toString() {
		return "Ingredient{" +
				"id=" + id +
				", name='" + name + '\'' +
				", quantity=" + quantity +
				", unit='" + unit + '\'' +
				'}';
	}
}
