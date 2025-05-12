package it.uniroma3.siw.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Objects;

@Entity
public class Grading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Recipe recipe;  // La ricetta che riceve il voto

    @ManyToOne(optional = false)
    private EndUser voter;  // L'utente che vota

    @Min(1)
    @Max(5)
    private int value;  // Il valore del voto (1-5)

    // Costruttori
    public Grading() {}

    public Grading(Recipe recipe, EndUser voter, int value) {
        this.recipe = recipe;
        this.voter = voter;
        this.value = value;
    }

    // Getter e Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public EndUser getVoter() {
        return voter;
    }

    public void setVoter(EndUser voter) {
        this.voter = voter;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recipe, voter, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Grading other = (Grading) obj;
        return Objects.equals(id, other.id) && Objects.equals(recipe, other.recipe)
                && Objects.equals(voter, other.voter) && value == other.value;
    }

    @Override
    public String toString() {
        return "Grading [id=" + id + ", recipe=" + recipe + ", voter=" + voter + ", value=" + value + "]";
    }
}
