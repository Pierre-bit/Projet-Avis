package org.projet.avis.service;

import java.time.LocalDate;
import java.util.List;

import org.projet.avis.model.Joueur;

public interface JoueurService {

	Joueur ajouterJoueur(Joueur Joueur);

	List<Joueur> getAllJoueurs();

	Joueur getJoueur(Long id);

	boolean deleteJoueur(long id);

	Joueur updateJoueur(long id, String pseudo, String password, String email,LocalDate dateDenaissance);
}
