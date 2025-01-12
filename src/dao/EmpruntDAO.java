package dao;

import biblio.Emprunt;

import java.util.List;

public interface EmpruntDAO {
    void enregistrerEmprunt(Emprunt emprunt);
    void gererRetour(int idEmprunt, java.util.Date dateRetourEffective);
    List<Emprunt> afficherTousLesEmprunts();
}
