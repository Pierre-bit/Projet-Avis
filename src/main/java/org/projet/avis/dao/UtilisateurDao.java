package org.projet.avis.dao;

import org.projet.avis.model.Utilisateur;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Long> {

	

	// utilisation d'une méthode par dérivation
	Page<Utilisateur> findByPseudoStartingWithIgnoreCase(Pageable pageable, String filter);

	static boolean findByEmail(boolean b) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
