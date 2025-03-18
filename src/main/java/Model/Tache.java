package Model;

import java.util.Date;

public class Tache {
    private int id_tache;
    private String nom;
    private Date date_debut;
    private Date date_fin;

    public Tache(int id_tache, String nom, Date date_debut, Date date_fin) {
        this.id_tache = id_tache;
        this.nom = nom;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public Tache() {
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

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    @Override
    public String toString() {
        return "Tache{" +
                "id_tache=" + id_tache +
                ", nom='" + nom + '\'' +
                ", date_debut=" + date_debut +
                ", date_fin=" + date_fin +
                '}';
    }
}
