package dao;

import biblio.Livre;
import bibliotheque.jdbc.DBConnection;

import java.sql.*;
import java.util.*;

public class LivreDAO {
    public void ajouterLivre(Livre livre) throws SQLException {
        String sql = "INSERT INTO livres (titre, auteur, nationaliteAuteur, categorie, isbn, dateParution, nombreExemplaires) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, livre.getTitre());
            ps.setString(2, livre.getAuteur());
            ps.setString(3, livre.getNationaliteAuteur());
            ps.setString(4, livre.getCategorie());
            ps.setString(5, livre.getIsbn());
            ps.setDate(6, new java.sql.Date(livre.getDateParution().getTime()));
            ps.setInt(7, livre.getNombreExemplaires());
            ps.executeUpdate();
            System.out.println("Livre ajouté avec succès !");
        }
    }

    public List<Livre> listerLivres() throws SQLException {
        String sql = "SELECT * FROM livres";
        List<Livre> livres = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Livre livre = new Livre(
                        rs.getInt("id"),
                        rs.getString("titre"),
                        rs.getString("auteur"),
                        rs.getString("nationaliteAuteur"),
                        rs.getString("categorie"),
                        rs.getString("isbn"),
                        rs.getDate("dateParution"),
                        rs.getInt("nombreExemplaires")
                );
                livres.add(livre);
            }
        }
        return livres;
    }

    public Livre rechercherLivreParTitre(String titre) throws SQLException {
        String sql = "SELECT * FROM livres WHERE titre = ?";
        try (Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, titre);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Livre(
                            rs.getInt("id"),
                            rs.getString("titre"),
                            rs.getString("auteur"),
                            rs.getString("nationaliteAuteur"),
                            rs.getString("categorie"),
                            rs.getString("isbn"),
                            rs.getDate("dateParution"),
                            rs.getInt("nombreExemplaires")
                    );
                }
            }
        }
        return null;
    }

    public void supprimerLivre(int id) throws SQLException {
        String sql = "DELETE FROM livres WHERE id = ?";
        try (Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Livre supprimé avec succès !");
        }
    }
}
