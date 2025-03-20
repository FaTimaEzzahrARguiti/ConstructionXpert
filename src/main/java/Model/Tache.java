package Model;

import java.util.Date;

public class Tache {
    private int id_tache;
    private String nom;
    private String date_debut;
    private String date_fin;
    private int id_projet;
    private int id_ressource;

    public Tache() {
    }

    public Tache(int id_tache, String nom, String date_debut, String date_fin, int id_projet, int id_ressource) {
        this.id_tache = id_tache;
        this.nom = nom;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.id_projet = id_projet;
        this.id_ressource = id_ressource;
    }

    public Tache(int id_tache, String nom, String date_debut, String date_fin) {
        this.id_tache = id_tache;
        this.nom = nom;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public Tache(String nom, String date_debut, String date_fin) {
        this.nom = nom;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public int getId_tache() {
        return id_tache;
    }

    public void setId_tache(int id_tache) {
        this.id_tache = id_tache;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public int getId_projet() {
        return id_projet;
    }

    public void setId_projet(int id_projet) {
        this.id_projet = id_projet;
    }

    public int getId_ressource() {
        return id_ressource;
    }

    public void setId_ressource(int id_ressource) {
        this.id_ressource = id_ressource;
    }

    @Override
    public String toString() {
        return "Tache{" +
                "id_tache=" + id_tache +
                ", nom='" + nom + '\'' +
                ", date_debut='" + date_debut + '\'' +
                ", date_fin='" + date_fin + '\'' +
                ", id_projet=" + id_projet +
                ", id_ressource=" + id_ressource +
                '}';
    }
}
