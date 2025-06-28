package it.uniroma3.siw.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class ProcedureStep {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	private String description; // Descrizione della procedura

	private int step; // Numero del passo nella procedura

	private List<Ingredient> ingredients; // Ingredienti necessari per questo passo

	private String note; // Note aggiuntive per questo passo

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ProcedureStep)) return false;
		ProcedureStep that = (ProcedureStep) o;
		return step == that.step &&
				id.equals(that.id) &&
				description.equals(that.description) &&
				ingredients.equals(that.ingredients) &&
				note.equals(that.note);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, description, step, ingredients, note);
	}

	@Override
	public String toString() {
		return "ProcedureStep{" +
				"id=" + id +
				", description='" + description + '\'' +
				", step=" + step +
				", ingredients=" + ingredients +
				", note='" + note + '\'' +
				'}';
	}

}
