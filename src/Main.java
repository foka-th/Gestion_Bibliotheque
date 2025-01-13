import biblio.Livre;
import biblio.Membre;
import dao.LivreDAOImpl;
import dao.MembreDAOImpl;

import java.util.*;
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final LivreDAOImpl livreDAO = new LivreDAOImpl();
    private static final MembreDAOImpl membreDAO = new MembreDAOImpl();

    public static void afficherMenuPrincipal() {
        int choix;
        do {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Gestion des Livres");
            System.out.println("2. Gestion des Membres");
            System.out.println("3. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Consomme la nouvelle ligne

            switch (choix) {
                case 1 -> menuLivres();
                case 2 -> menuMembres();
                case 3 -> System.out.println("Au revoir !");
                default -> System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 3);
    }

    private static void menuLivres() {
        int choix;
        do {
            System.out.println("\n--- Gestion des Livres ---");
            System.out.println("1. Ajouter un Livre");
            System.out.println("2. Afficher tous les Livres");
            System.out.println("3. Rechercher un Livre par Titre");
            System.out.println("4. Retour");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> ajouterLivre();
                case 2 -> afficherTousLesLivres();
                case 3 -> rechercherLivre();
                case 4 -> System.out.println("Retour au menu principal.");
                default -> System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 4);
    }

    private static void ajouterLivre() {
        System.out.print("Titre : ");
        String titre = scanner.nextLine();
        System.out.print("Auteur : ");
        String auteur = scanner.nextLine();
        System.out.print("Catégorie : ");
        String categorie = scanner.nextLine();
        System.out.print("Nombre d'exemplaires : ");
        int nombreExemplaires = scanner.nextInt();
        scanner.nextLine();

        Livre livre = new Livre(0, titre, auteur, categorie, nombreExemplaires);
        livreDAO.ajouterLivre(livre);
        System.out.println("Livre ajouté avec succès.");
    }

    private static void afficherTousLesLivres() {
        livreDAO.afficherTousLesLivres().forEach(Livre::afficherDetails);
    }

    private static void rechercherLivre() {
        System.out.print("Titre du livre à rechercher : ");
        String titre = scanner.nextLine();
        Livre livre = livreDAO.rechercherLivreParTitre(titre);
        if (livre != null) {
            livre.afficherDetails();
        } else {
            System.out.println("Aucun livre trouvé avec ce titre.");
        }
    }

    private static void menuMembres() {
        int choix;
        do {
            System.out.println("\n--- Gestion des Membres ---");
            System.out.println("1. Inscrire un Membre");
            System.out.println("2. Afficher tous les Membres");
            System.out.println("3. Retour");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> inscrireMembre();
                case 2 -> afficherTousLesMembres();
                case 3 -> System.out.println("Retour au menu principal.");
                default -> System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 3);
    }

    private static void inscrireMembre() {
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();
        System.out.print("Email : ");
        String email = scanner.nextLine();
        System.out.print("Date d'adhésion (yyyy-MM-dd) : ");
        String dateAdhesion = scanner.nextLine();

        Membre membre = new Membre(0, nom, prenom, email, java.sql.Date.valueOf(dateAdhesion));
        membreDAO.inscrireMembre(membre);
        System.out.println("Membre inscrit avec succès.");
    }

    private static void afficherTousLesMembres() {
        membreDAO.afficherTousLesMembres().forEach(Membre::afficherDetails);
    }

    public static void main(String[] args) {
        afficherMenuPrincipal();
    }
}
