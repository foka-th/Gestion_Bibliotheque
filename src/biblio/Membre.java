package biblio;


import java.util.Date;

public class Membre {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private Date adhesionDate;

    // Constructeur, getters et setters
    public Membre(int id, String nom, String prenom, String email, String telephone, Date adhesionDate) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.adhesionDate = adhesionDate;
    }

    public Membre() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getAdhesionDate() {
        return adhesionDate;
    }

    public void setAdhesionDate(Date adhesionDate) {
        this.adhesionDate = adhesionDate;
    }

    @Override
    public String toString() {
        return "Membre [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", telephone=" + telephone + ", adhesionDate=" + adhesionDate + "]";
    }
}