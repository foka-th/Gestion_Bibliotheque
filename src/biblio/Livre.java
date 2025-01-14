package biblio;

import java.time.LocalDate;
import java.util.Date;

public class Livre {
    private int id;
    private String titre;
    private String auteur;
    private String nationaliteAuteur;
    private String categorie;
    private String isbn;
    private Date dateParution;
    private int nombreExemplaires;

    // Constructeur, getters et setters
    public Livre(int id, String titre, String auteur, String nationaliteAuteur, String categorie, String isbn, Date dateParution, int nombreExemplaires) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.nationaliteAuteur = nationaliteAuteur;
        this.categorie = categorie;
        this.isbn = isbn;
        this.dateParution = dateParution;
        this.nombreExemplaires = nombreExemplaires;
    }

    public Livre() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getNationaliteAuteur() {
        return nationaliteAuteur;
    }

    public void setNationaliteAuteur(String nationaliteAuteur) {
        this.nationaliteAuteur = nationaliteAuteur;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getDateParution() {
        return dateParution;
    }

    public void setDateParution(Date dateParution) {
        this.dateParution = dateParution;
    }

    public int getNombreExemplaires() {
        return nombreExemplaires;
    }

    public void setNombreExemplaires(int nombreExemplaires) {
        this.nombreExemplaires = nombreExemplaires;
    }

    @Override
    public String toString() {
        return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", nationaliteAuteur=" + nationaliteAuteur + ", categorie=" + categorie + ", isbn=" + isbn + ", dateParution=" + dateParution + ", nombreExemplaires=" + nombreExemplaires + "]";
    }
}
