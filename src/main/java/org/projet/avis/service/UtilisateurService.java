package org.projet.avis.service;

import java.util.List;

import org.projet.avis.model.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UtilisateurService {

	Utilisateur ajouterUser(Utilisateur utilisateur);
	
	List<Utilisateur> getAllUsers();
	
	Utilisateur getUser(Long id);
	
	boolean deleteUser(long id);

	Utilisateur updateUser(long id, String pseudo, String password, String email);
	
	Page<Utilisateur> getUtilisateurs(Pageable pageable, String filter);
	
	
}
