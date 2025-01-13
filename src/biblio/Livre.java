package biblio;

public class Livre {
    private int id;
    private String isbn;
    private String titre;
    private String auteur;
    private String nationaliteAuteur;
    private String categorie;
    private int nombreExemplaires;

    // Constructeurs
    public Livre(int id, String isbn, String titre, String auteur, String nationaliteAuteur, String categorie, int nombreExemplaires) {
        this.id = id;
        this.isbn = isbn;
        this.titre = titre;
        this.auteur = auteur;
        this.nationaliteAuteur = nationaliteAuteur;
        this.categorie = categorie;
        this.nombreExemplaires = nombreExemplaires;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }
    public String getAuteur() { return auteur; }
    public void setAuteur(String auteur) { this.auteur = auteur; }
    public String getNationaliteAuteur() { return nationaliteAuteur; }
    public void setNationaliteAuteur(String nationaliteAuteur) { this.nationaliteAuteur = nationaliteAuteur; }
    public String getCategorie() { return categorie; }
    public void setCategorie(String categorie) { this.categorie = categorie; }
    public int getNombreExemplaires() { return nombreExemplaires; }
    public void setNombreExemplaires(int nombreExemplaires) { this.nombreExemplaires = nombreExemplaires; }

    // Méthodes personnalisées
    public void afficherDetails() {
        System.out.println("ID : " + id + ", ISBN : " + isbn + ", Titre : " + titre + ", Auteur : " + auteur + "Natationalité : " + nationaliteAuteur + ", Catégorie : " + categorie + ", Exemplaires : " + nombreExemplaires);
    }
}
