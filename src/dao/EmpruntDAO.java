package dao;

import biblio.Emprunt;
import bibliotheque.jdbc.DBConnection;

import java.sql.*;
import java.util.Optional;

public class EmpruntDAO {

    // Méthode pour enregistrer un emprunt
    public void enregistrerEmprunt(Emprunt emprunt) {
        String sql = "INSERT INTO emprunts (membreId, livreId, dateEmprunt, dateRetourPrevue, dateRetourEffective) VALUES (?, ?, ?, ?, NULL)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, emprunt.getMembreId());
            ps.setInt(2, emprunt.getLivreId());
            ps.setDate(3, new java.sql.Date(emprunt.getDateEmprunt().getTime()));
            ps.setDate(4, new java.sql.Date(emprunt.getDateRetourPrevue().getTime()));
            ps.executeUpdate();

            System.out.println("Emprunt enregistré avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'enregistrement de l'emprunt : " + e.getMessage());
        }
    }

    // Méthode pour enregistrer un retour
    public void enregistrerRetour(int idEmprunt, java.sql.Date dateRetourEffective) {
        String sql = "UPDATE emprunts SET dateRetourEffective = ? WHERE idEmprunt = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setDate(1, dateRetourEffective);
            ps.setInt(2, idEmprunt);
            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Retour enregistré avec succès !");
            } else {
                System.out.println("Aucun emprunt trouvé avec l'ID : " + idEmprunt);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'enregistrement du retour : " + e.getMessage());
        }
    }

    // Méthode pour calculer les pénalités
    public Optional<Integer> calculerPenalite(int idEmprunt) {
        String sql = "SELECT dateRetourPrevue, dateRetourEffective FROM emprunts WHERE idEmprunt = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, idEmprunt);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Date dateRetourPrevue = rs.getDate("dateRetourPrevue");
                    Date dateRetourEffective = rs.getDate("dateRetourEffective");

                    if (dateRetourEffective != null && dateRetourEffective.after(dateRetourPrevue)) {
                        long diffInMillies = dateRetourEffective.getTime() - dateRetourPrevue.getTime();
                        long diffInDays = diffInMillies / (24 * 60 * 60 * 1000);

                        return Optional.of((int) diffInDays * 100); // 100 F CFA par jour de retard
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors du calcul des pénalités : " + e.getMessage());
        }
        return Optional.empty(); // Pas de pénalité ou emprunt introuvable
    }
}
