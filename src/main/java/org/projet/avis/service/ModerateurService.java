package org.projet.avis.service;

import java.util.List;

import org.projet.avis.model.Moderateur;
import org.projet.avis.model.Moderateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ModerateurService {

	Moderateur ajouterModerateur(Moderateur Moderateur);

	List<Moderateur> getAllModerateurs();

	Moderateur getModerateur(Long id);

	boolean deleteModerateur(long id);

	Moderateur updateModerateur(long id, String pseudo, String password, String email,String numero);

}
