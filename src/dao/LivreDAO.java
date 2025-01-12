package dao;

import biblio.Livre;

import java.util.List;

public interface LivreDAO {
    void ajouterLivre(Livre livre);
    void modifierLivre(Livre livre);
    void supprimerLivre(int id);
    Livre rechercherLivreParTitre(String titre);
    List<Livre> afficherTousLesLivres();
}
