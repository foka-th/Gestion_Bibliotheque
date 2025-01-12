package biblio;


import java.util.Date;

public class Membre {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private Date adhesionDate;

    // Constructeur
    public Membre(int id, String nom, String prenom, String email, Date adhesionDate) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adhesionDate = adhesionDate;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public java.sql.Date getAdhesionDate() { return (java.sql.Date) adhesionDate; }
    public void setAdhesionDate(Date adhesionDate) { this.adhesionDate = adhesionDate; }

    // Méthodes personnalisées
    public void afficherDetails() {
        System.out.println("ID : " + id + ", Nom : " + nom + ", Prénom : " + prenom + ", Email : " + email + ", Date d'adhésion : " + adhesionDate);
    }
}
