package dao;

import biblio.Membre;
import bibliotheque.jdbc.DBConnection;

import java.sql.*;
import java.util.*;

public class MembreDAO {
    public void inscrireMembre(Membre membre) throws SQLException {
        String sql = "INSERT INTO membres (nom, prenom, email, telephone, adhesionDate) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, membre.getNom());
            ps.setString(2, membre.getPrenom());
            ps.setString(3, membre.getEmail());
            ps.setString(4, membre.getTelephone());
            ps.setDate(5, new java.sql.Date(membre.getAdhesionDate().getTime()));
            ps.executeUpdate();
            System.out.println("Membre inscrit avec succès !");
        }
    }

    public List<Membre> listerMembres() throws SQLException {
        String sql = "SELECT * FROM membres";
        List<Membre> membres = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Membre membre = new Membre(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("telephone"),
                        rs.getDate("adhesionDate")
                );
                membres.add(membre);
            }
        }
        return membres;
    }

    public void supprimerMembre(int id) throws SQLException {
        String sql = "DELETE FROM membres WHERE id = ?";
        try (Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Membre supprimé avec succès !");
        }
    }
}
