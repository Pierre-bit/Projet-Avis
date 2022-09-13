package org.projet.avis.service;

import java.time.LocalDate;
import java.util.List;

import org.projet.avis.model.Jeu;

public interface JeuService {

	Jeu addJeu(Jeu jeu);
	
	List<Jeu> getAllJeux();
	
	Jeu getJeu(Long id);
	
	Jeu updateJeu(long id,String nom,String description,
			LocalDate dateSortie,String image);
	
	boolean deleteJeu(Long id);

}
