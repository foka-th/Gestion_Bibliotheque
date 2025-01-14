package dao;

import biblio.Livre;
import bibliotheque.jdbc.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivreDAOImpl {
    public void ajouterLivre(Livre livre) {
        String sql = "INSERT INTO livres (titre, auteur, categorie, nombre_exemplaires) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, livre.getTitre());
            stmt.setString(2, livre.getAuteur());
            stmt.setString(3, livre.getCategorie());
            stmt.setInt(4, livre.getNombreExemplaires());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Livre> afficherTousLesLivres() {
        List<Livre> livres = new ArrayList<>();
        String sql = "SELECT * FROM livres";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Livre livre = new Livre(
                        rs.getInt("id"),
                        rs.getString("isbn"),
                        rs.getString("titre"),
                        rs.getString("auteur"),
                        rs.getString("nationaliteAuteur"),
                        rs.getString("categorie"),
                        rs.getDate("dateParution"),
                        rs.getInt("nombreExemplaires")
                );
                livres.add(livre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livres;
    }

    public Livre rechercherLivreParTitre(String titre) {
        String sql = "SELECT * FROM livres WHERE titre = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, titre);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Livre(
                            rs.getInt("id"),
                            rs.getString("isbn"),
                            rs.getString("titre"),
                            rs.getString("auteur"),
                            rs.getString("nationaliteAuteur"),
                            rs.getString("categorie"),
                            rs.getDate("dateParution"),
                            rs.getInt("nombreExemplaires")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

