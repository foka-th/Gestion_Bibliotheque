package dao;

import biblio.Membre;
import bibliotheque.jdbc.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MembreDAOImpl {

    // Ajouter un membre dans la base de données
    public void inscrireMembre(Membre membre) {
        String sql = "INSERT INTO membres (nom, prenom, email, adhesion_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, membre.getNom());
            stmt.setString(2, membre.getPrenom());
            stmt.setString(3, membre.getEmail());
            stmt.setDate(4, membre.getAdhesionDate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'inscription du membre : " + e.getMessage());
        }
    }

    // Récupérer la liste de tous les membres
    public List<Membre> afficherTousLesMembres() {
        List<Membre> membres = new ArrayList<>();
        String sql = "SELECT * FROM membres";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Membre membre = new Membre(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getDate("adhesion_date")
                );
                membres.add(membre);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des membres : " + e.getMessage());
        }
        return membres;
    }

    // Rechercher un membre par son ID
    public Membre rechercherMembreParId(int id) {
        String sql = "SELECT * FROM membres WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Membre(
                            rs.getInt("id"),
                            rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getString("email"),
                            rs.getDate("adhesion_date")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche du membre : " + e.getMessage());
        }
        return null;
    }

    // Supprimer un membre par son ID
    public void supprimerMembre(int id) {
        String sql = "DELETE FROM membres WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Membre supprimé avec succès.");
            } else {
                System.out.println("Aucun membre trouvé avec cet ID.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression du membre : " + e.getMessage());
        }
    }

    // Mettre à jour les informations d'un membre
    public void mettreAJourMembre(Membre membre) {
        String sql = "UPDATE membres SET nom = ?, prenom = ?, email = ?, adhesion_date = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, membre.getNom());
            stmt.setString(2, membre.getPrenom());
            stmt.setString(3, membre.getEmail());
            stmt.setDate(4, membre.getAdhesionDate());
            stmt.setInt(5, membre.getId());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Membre mis à jour avec succès.");
            } else {
                System.out.println("Aucun membre trouvé avec cet ID.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour du membre : " + e.getMessage());
        }
    }
}

