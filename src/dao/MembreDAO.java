package dao;

import biblio.Membre;

import java.util.List;

public interface MembreDAO {
    void inscrireMembre(Membre membre);
    void supprimerMembre(int id);
    Membre rechercherMembreParNom(String nom);
    List<Membre> afficherTousLesMembres();
}
