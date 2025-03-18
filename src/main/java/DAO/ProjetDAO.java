package DAO;

import Model.Projet;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProjetDAO {
    private Connection connection;

    public ProjetDAO() {
        // Votre constructeur existant reste inchangé
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/etud_cours", "root", "");
            if (this.connection == null) {
                throw new SQLException("Failed to establish database connection!");
            }
            try (Statement statement = connection.createStatement()) {
                String sql = "CREATE TABLE IF NOT EXISTS projet (" +
                        "id_projet INT PRIMARY KEY AUTO_INCREMENT, " +
                        "nom VARCHAR(100) NOT NULL, " +
                        "description VARCHAR(100) NOT NULL, " +
                        "date_debut DATE NOT NULL, " +
                        "date_fin DATE NOT NULL" +
                        ")";
                statement.executeUpdate(sql);
                System.out.println("Table 'projet' created successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Méthodes existantes : AddProjet et selectAllProjets
    public void AddProjet(Projet projet) throws SQLException {
        String sql = "INSERT INTO projet (nom, description, date_debut, date_fin, budget) VALUES (?, ?, ?, ?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, projet.getNom());
            stmt.setString(2, projet.getDescription());
           // stmt.setDate(3, (LocalDate) projet.getDate_debut());
          //  stmt.setDate(4, (Date) projet.getDate_fin());
            stmt.setInt(1, projet.getBudget());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

        }
    }

    public List<Projet> selectAllProjets() throws SQLException {
        List<Projet> projets = new ArrayList<>();
        String query = "SELECT * FROM projet";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
               // Projet projet = new Projet(rs.getInt("id_projet"), rs.getString("nom"),
                     //   rs.getString("description"), rs.getDate("date_debut"), rs.getDate("date_fin"),rs.getInt("budget"));
                //projets.add(projet);
            }
        }
        return projets;
    }

    // Nouvelles méthodes : updateProjet et deleteProjet
    public void updateProjet(Projet projet) throws SQLException {
        String sql = "UPDATE projet SET nom = ?, description = ?, date_debut = ?, date_fin = ? WHERE id_projet = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, projet.getNom());
            stmt.setString(2, projet.getDescription());
           // stmt.setDate(3, (Date) projet.getDate_debut());
           // stmt.setDate(4, (Date) projet.getDate_fin());
            stmt.setInt(5, projet.getId_projet());
            stmt.executeUpdate();
        }
    }

    public void deleteProjet(int id) throws SQLException {
        String sql = "DELETE FROM projet WHERE id_projet = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}