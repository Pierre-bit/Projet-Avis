package org.projet.avis.dao;

import org.projet.avis.model.Jeu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JeuDao extends JpaRepository<Jeu, Long> {

	boolean findByNom(boolean b);
	
	

	

}
