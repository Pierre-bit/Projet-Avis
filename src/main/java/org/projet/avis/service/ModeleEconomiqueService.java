package org.projet.avis.service;

import java.util.List;

import org.projet.avis.model.ModeleEconomique;

public interface ModeleEconomiqueService {
	
	ModeleEconomique ajouterModeleEconomique(ModeleEconomique modeleEconomique);

	List<ModeleEconomique> getAllModeleEconomiques();

	ModeleEconomique getModeleEconomique(Long id);

	boolean deleteModeleEconomique(long id);

	ModeleEconomique udpateModeleEconomique(Long id, String nom);

}
