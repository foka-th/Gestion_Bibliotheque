import biblio.*;
import dao.*;

import java.sql.Date;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final LivreDAO livreDAO = new LivreDAO();
    private static final MembreDAO membreDAO = new MembreDAO();
    private static final EmpruntDAO empruntDAO = new EmpruntDAO();

    public static void main(String[] args) {
        boolean continuer = true;
        while (continuer) {
            afficherMenuPrincipal();
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consomme la nouvelle ligne restante

            switch (choix) {
                case 1 -> ajouterLivre();
                case 2 -> listerLivres();
                case 3 -> inscrireMembre();
                case 4 -> listerMembres();
                case 5 -> enregistrerEmprunt();
                case 6 -> enregistrerRetour();
                case 7 -> calculerPenalite();
                case 0 -> continuer = false;
                default -> System.out.println("Choix invalide. Réessayez.");
            }
        }
    }

    private static void afficherMenuPrincipal() {
        System.out.println("\n--- Menu Principal ---");
        System.out.println("1. Ajouter un livre");
        System.out.println("2. Lister les livres");
        System.out.println("3. Inscrire un membre");
        System.out.println("4. Lister les membres");
        System.out.println("5. Enregistrer un emprunt");
        System.out.println("6. Enregistrer un retour");
        System.out.println("7. Calculer les pénalités");
        System.out.println("0. Quitter");
        System.out.print("Votre choix : ");
    }

    private static void ajouterLivre() {
        try {
            System.out.print("Titre : ");
            String titre = scanner.nextLine();
            System.out.print("Auteur : ");
            String auteur = scanner.nextLine();
            System.out.print("Nationalité de l'auteur : ");
            String nationaliteAuteur = scanner.nextLine();
            System.out.print("Catégorie : ");
            String categorie = scanner.nextLine();
            System.out.print("ISBN : ");
            String isbn = scanner.nextLine();
            System.out.print("Date de parution (yyyy-MM-dd) : ");
            String dateStr = scanner.nextLine();
            Date dateParution = Date.valueOf(dateStr);
            System.out.print("Nombre d'exemplaires : ");
            int nombreExemplaires = scanner.nextInt();

            Livre livre = new Livre(0, titre, auteur, nationaliteAuteur, categorie, isbn, dateParution, nombreExemplaires);
            livreDAO.ajouterLivre(livre);
            System.out.println("Livre ajouté avec succès !");
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : Format de date incorrect. Utilisez le format yyyy-MM-dd.");
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    private static void listerLivres() {
        try {
            livreDAO.listerLivres().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération des livres : " + e.getMessage());
        }
    }

    private static void inscrireMembre() {
        try {
            System.out.print("Nom : ");
            String nom = scanner.nextLine();
            System.out.print("Prénom : ");
            String prenom = scanner.nextLine();
            System.out.print("Email : ");
            String email = scanner.nextLine();
            System.out.print("Téléphone : ");
            String telephone = scanner.nextLine();
            System.out.print("Date d'adhésion (yyyy-MM-dd) : ");
            String dateStr = scanner.nextLine();
            Date adhesionDate = Date.valueOf(dateStr);

            Membre membre = new Membre(0, nom, prenom, email, telephone, adhesionDate);
            membreDAO.inscrireMembre(membre);
            System.out.println("Membre inscrit avec succès !");
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : Format de date incorrect. Utilisez le format yyyy-MM-dd.");
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    private static void listerMembres() {
        try {
            membreDAO.listerMembres().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération des membres : " + e.getMessage());
        }
    }

    private static void enregistrerEmprunt() {
        try {
            System.out.print("ID du membre : ");
            int membreId = scanner.nextInt();
            System.out.print("ID du livre : ");
            int livreId = scanner.nextInt();
            scanner.nextLine(); // Consomme la nouvelle ligne restante
            System.out.print("Date d'emprunt (yyyy-MM-dd) : ");
            String dateEmpruntStr = scanner.nextLine();
            Date dateEmprunt = Date.valueOf(dateEmpruntStr);
            System.out.print("Date retour prévue (yyyy-MM-dd) : ");
            String dateRetourStr = scanner.nextLine();
            Date dateRetourPrevue = Date.valueOf(dateRetourStr);

            Emprunt emprunt = new Emprunt(0, membreId, livreId, dateEmprunt, dateRetourPrevue, null);
            empruntDAO.enregistrerEmprunt(emprunt);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : Format de date incorrect. Utilisez le format yyyy-MM-dd.");
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    private static void enregistrerRetour() {
        try {
            System.out.print("ID de l'emprunt : ");
            int empruntId = scanner.nextInt();
            scanner.nextLine(); // Consomme la nouvelle ligne restante
            System.out.print("Date de retour (yyyy-MM-dd) : ");
            String dateRetourStr = scanner.nextLine();
            Date dateRetourEffective = Date.valueOf(dateRetourStr);

            empruntDAO.enregistrerRetour(empruntId, dateRetourEffective);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : Format de date incorrect. Utilisez le format yyyy-MM-dd.");
        } catch (Exception e) {
            System.out.println("Erreur lors de l'enregistrement du retour : " + e.getMessage());
        }
    }

    private static void calculerPenalite() {
        try {
            System.out.print("ID de l'emprunt : ");
            int empruntId = scanner.nextInt();

            var penalite = empruntDAO.calculerPenalite(empruntId);
            penalite.ifPresentOrElse(
                    value -> System.out.println("Pénalité : " + value + " F CFA"),
                    () -> System.out.println("Pas de pénalité ou emprunt introuvable.")
            );
        } catch (Exception e) {
            System.out.println("Erreur lors du calcul des pénalités : " + e.getMessage());
        }
    }
}
