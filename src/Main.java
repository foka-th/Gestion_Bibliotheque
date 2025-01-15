import biblio.*;
import dao.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final LivreDAO livreDAO = new LivreDAO();
    private static final MembreDAO membreDAO = new MembreDAO();
    private static final EmpruntDAO empruntDAO = new EmpruntDAO();

    public static void main(String[] args) {
        boolean continuer = true;
        while (continuer) {
            afficherMenuPrincipal();
            int choix = lireEntier("Votre choix : ");

            switch (choix) {
                case 1 -> gestionLivres();
                case 2 -> gestionMembres();
                case 3 -> gestionEmpruntsEtPenalites();
                case 0 -> continuer = false;
                default -> System.out.println("Choix invalide. Réessayez.");
            }
        }
    }

    private static void afficherMenuPrincipal() {
        System.out.println("\n--- Menu Principal ---");
        System.out.println("1. Gestion des livres");
        System.out.println("2. Gestion des membres");
        System.out.println("3. Gestion des emprunts et pénalités");
        System.out.println("0. Quitter");
    }

    private static int lireEntier(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Erreur : Veuillez entrer un nombre entier valide.");
            }
        }
    }

    private static Date lireDate(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Date.valueOf(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur : Format de date incorrect. Utilisez le format yyyy-MM-dd.");
            }
        }
    }

    // Gestion des livres
    private static void gestionLivres() {
        System.out.println("\n--- Gestion des livres ---");
        System.out.println("1. Ajouter un livre");
        System.out.println("2. Lister les livres");
        System.out.println("3. Rechercher un livre par titre");
        System.out.println("4. Supprimer un livre");
        int choix = lireEntier("Votre choix : ");

        switch (choix) {
            case 1 -> ajouterLivre();
            case 2 -> listerLivres();
            case 3 -> rechercherLivreParTitre();
            case 4 -> supprimerLivre();
            default -> System.out.println("Choix invalide.");
        }
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
            Date dateParution = lireDate("Date de parution (yyyy-MM-dd) : ");
            int nombreExemplaires = lireEntier("Nombre d'exemplaires : ");

            Livre livre = new Livre(0, titre, auteur, nationaliteAuteur, categorie, isbn, dateParution, nombreExemplaires);
            livreDAO.ajouterLivre(livre);
            System.out.println("Livre ajouté avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du livre : " + e.getMessage());
        }
    }

    private static void listerLivres() {
        try {
            List<Livre> livres = livreDAO.listerLivres();
            if (livres.isEmpty()) {
                System.out.println("Aucun livre trouvé.");
            } else {
                livres.forEach(System.out::println);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des livres : " + e.getMessage());
        }
    }

    private static void rechercherLivreParTitre() {
        try {
            System.out.print("Titre du livre à rechercher : ");
            String titre = scanner.nextLine();
            Livre livre = livreDAO.rechercherLivreParTitre(titre);
            if (livre != null) {
                System.out.println(livre);
            } else {
                System.out.println("Aucun livre trouvé avec ce titre.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche : " + e.getMessage());
        }
    }

    private static void supprimerLivre() {
        try {
            int livreId = lireEntier("ID du livre à supprimer : ");
            livreDAO.supprimerLivre(livreId);
            System.out.println("Livre supprimé avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression du livre : " + e.getMessage());
        }
    }

    // Gestion des membres
    private static void gestionMembres() {
        System.out.println("\n--- Gestion des membres ---");
        System.out.println("1. Inscrire un membre");
        System.out.println("2. Lister les membres");
        System.out.println("3. Supprimer un membre");
        int choix = lireEntier("Votre choix : ");

        switch (choix) {
            case 1 -> inscrireMembre();
            case 2 -> listerMembres();
            case 3 -> supprimerMembre();
            default -> System.out.println("Choix invalide.");
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
            Date adhesionDate = lireDate("Date d'adhésion (yyyy-MM-dd) : ");

            Membre membre = new Membre(0, nom, prenom, email, telephone, adhesionDate);
            membreDAO.inscrireMembre(membre);
            System.out.println("Membre inscrit avec succès !");
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    private static void listerMembres() {
        try {
            List<Membre> membres = membreDAO.listerMembres();
            if (membres.isEmpty()) {
                System.out.println("Aucun membre trouvé.");
            } else {
                membres.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération des membres : " + e.getMessage());
        }
    }

    private static void supprimerMembre() {
        try {
            int membreId = lireEntier("ID du membre à supprimer : ");
            membreDAO.supprimerMembre(membreId);
            System.out.println("Membre supprimé avec succès !");
        } catch (Exception e) {
            System.out.println("Erreur lors de la suppression du membre : " + e.getMessage());
        }
    }

    // Gestion des emprunts et pénalités
    private static void gestionEmpruntsEtPenalites() {
        System.out.println("\n--- Gestion des emprunts et pénalités ---");
        System.out.println("1. Enregistrer un emprunt");
        System.out.println("2. Enregistrer un retour");
        System.out.println("3. Calculer les pénalités");
        int choix = lireEntier("Votre choix : ");

        switch (choix) {
            case 1 -> enregistrerEmprunt();
            case 2 -> enregistrerRetour();
            case 3 -> calculerPenalite();
            default -> System.out.println("Choix invalide.");
        }
    }

    private static void enregistrerEmprunt() {
        try {
            int membreId = lireEntier("ID du membre : ");
            int livreId = lireEntier("ID du livre : ");
            Date dateEmprunt = lireDate("Date d'emprunt (yyyy-MM-dd) : ");
            Date dateRetour = lireDate("Date retour prévue (yyyy-MM-dd) : ");

            Emprunt emprunt = new Emprunt(0, membreId, livreId, dateEmprunt, dateRetour, null);
            empruntDAO.enregistrerEmprunt(emprunt);

            System.out.println("Emprunt enregistré avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'enregistrement de l'emprunt : " + e.getMessage());
        }
    }


    private static void enregistrerRetour() {
        System.out.println("Cette fonctionnalité sera bientôt disponible.");
    }

    private static void calculerPenalite() {
        System.out.println("Cette fonctionnalité sera bientôt disponible.");
    }
}
