package it.uniroma3.siw.model;

import jakarta.persistence.*;
import java.util.Objects;
import it.uniroma3.siw.validation.ValidGrading;

@Entity
public class Grading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Recipe recipe; // La ricetta che riceve il voto

    @ManyToOne(optional = false)
    private User voter; // L'utente che vota

    @ValidGrading
    private int value; // Il valore del voto (1-5)

    // Costruttori
    public Grading() {
    }

    public Grading(Recipe recipe, User voter, int value) {
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

    public User getVoter() {
        return voter;
    }

    public void setVoter(User voter) {
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
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Grading other = (Grading) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Grading{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
