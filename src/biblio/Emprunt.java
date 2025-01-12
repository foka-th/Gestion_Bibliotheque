package biblio;

import java.util.Date;

public class Emprunt {
    private int idEmprunt;
    private int membreId;
    private int livreId;
    private Date dateEmprunt;
    private Date dateRetourPrevue;
    private Date dateRetourEffective;

    // Constructeur
    public Emprunt(int idEmprunt, int membreId, int livreId, Date dateEmprunt, Date dateRetourPrevue, Date dateRetourEffective) {
        this.idEmprunt = idEmprunt;
        this.membreId = membreId;
        this.livreId = livreId;
        this.dateEmprunt = dateEmprunt;
        this.dateRetourPrevue = dateRetourPrevue;
        this.dateRetourEffective = dateRetourEffective;
    }

    // Getters et Setters
    public int getIdEmprunt() { return idEmprunt; }
    public void setIdEmprunt(int idEmprunt) { this.idEmprunt = idEmprunt; }
    public int getMembreId() { return membreId; }
    public void setMembreId(int membreId) { this.membreId = membreId; }
    public int getLivreId() { return livreId; }
    public void setLivreId(int livreId) { this.livreId = livreId; }
    public Date getDateEmprunt() { return dateEmprunt; }
    public void setDateEmprunt(Date dateEmprunt) { this.dateEmprunt = dateEmprunt; }
    public Date getDateRetourPrevue() { return dateRetourPrevue; }
    public void setDateRetourPrevue(Date dateRetourPrevue) { this.dateRetourPrevue = dateRetourPrevue; }
    public Date getDateRetourEffective() { return dateRetourEffective; }
    public void setDateRetourEffective(Date dateRetourEffective) { this.dateRetourEffective = dateRetourEffective; }

    // Méthodes personnalisées
    public void afficherDetails() {
        System.out.println("ID Emprunt : " + idEmprunt + ", Membre ID : " + membreId + ", Livre ID : " + livreId + ", Date Emprunt : " + dateEmprunt + ", Date Retour Prévue : " + dateRetourPrevue + ", Date Retour Effective : " + dateRetourEffective);
    }
}
