package biblio;

public class Livre {
    private int id;
    private String titre;
    private String auteur;
    private String categorie;
    private int nombreExemplaires;

    // Constructeurs
    public Livre(int id, String titre, String auteur, String categorie, int nombreExemplaires) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.categorie = categorie;
        this.nombreExemplaires = nombreExemplaires;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }
    public String getAuteur() { return auteur; }
    public void setAuteur(String auteur) { this.auteur = auteur; }
    public String getCategorie() { return categorie; }
    public void setCategorie(String categorie) { this.categorie = categorie; }
    public int getNombreExemplaires() { return nombreExemplaires; }
    public void setNombreExemplaires(int nombreExemplaires) { this.nombreExemplaires = nombreExemplaires; }

    // Méthodes personnalisées
    public void afficherDetails() {
        System.out.println("ID : " + id + ", Titre : " + titre + ", Auteur : " + auteur + ", Catégorie : " + categorie + ", Exemplaires : " + nombreExemplaires);
    }
}
