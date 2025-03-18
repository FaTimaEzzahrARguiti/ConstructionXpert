package Model;

import java.time.LocalDate;
import java.util.Date;

public class Projet {
    private int id_projet;
    private String nom;
    private String description;
    private LocalDate date_debut;
    private LocalDate date_fin;
    private int budget;

    public Projet(int id_projet, String nom, String description, LocalDate date_debut, LocalDate date_fin, int budget) {
        this.id_projet = id_projet;
        this.nom = nom;
        this.description = description;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.budget = budget;
    }

    public Projet(String nom, String description, LocalDate date_debut, LocalDate date_fin, int budget) {
        this.id_projet = id_projet;
        this.nom = nom;
        this.description = description;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.budget = budget;
    }


    public int getId_projet() {
        return id_projet;
    }

    public void setId_projet(int id_projet) {
        this.id_projet = id_projet;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(LocalDate date_debut) {
        this.date_debut = date_debut;
    }

    public LocalDate getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(LocalDate date_fin) {
        this.date_fin = date_fin;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public Projet() {

    }

    @Override
    public String toString() {
        return "Projet{" +
                "id_projet=" + id_projet +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", date_debut=" + date_debut +
                ", date_fin=" + date_fin +
                ", budget=" + budget +
                '}';
    }
}
