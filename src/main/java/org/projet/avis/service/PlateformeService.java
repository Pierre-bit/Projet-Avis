package org.projet.avis.service;

import java.util.List;

import org.projet.avis.model.Plateforme;


public interface PlateformeService {
	
	Plateforme ajouterPlateforme(Plateforme plateforme);

	List<Plateforme> getAllPlateformes();

	Plateforme getPlateforme(Long id);

	boolean deletePlateforme(long id);

	Plateforme udpatePlateforme(Long id, String nom);

}
