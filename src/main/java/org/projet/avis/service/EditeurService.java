package org.projet.avis.service;

import java.util.List;

import org.projet.avis.model.Editeur;

public interface EditeurService {

	Editeur ajouterEditeur(Editeur editeur);

	List<Editeur> getAllEditeurs();

	Editeur getEditeur(Long id);

	boolean deleteEditeur(long id);

	Editeur udpateEditeur(Long id, String nom);
}
