package org.projet.avis.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.projet.avis.dao.JoueurDao;
import org.projet.avis.model.Joueur;
import org.projet.avis.service.JoueurService;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JoueurServiceImpl implements JoueurService {

	private final JoueurDao joueurDao;
	@Override
	public Joueur ajouterJoueur(Joueur joueur) {
		return joueurDao.save(joueur);
	}

	@Override
	public List<Joueur> getAllJoueurs() {
		return joueurDao.findAll();
	}

	@Override
	public Joueur getJoueur(Long id) {
		return joueurDao.findById(id).orElse(null);
	}

	@Override
	public boolean deleteJoueur(long id) {
		Joueur joueur = getJoueur(id);
		if (joueur == null)
		{
			return false;
		}
		joueurDao.delete(joueur);
		return true;
	}

	@Override
	public Joueur updateJoueur(long id, String pseudo, String password, String email, LocalDate dateDenaissance) {
		Joueur joueur = getJoueur(id);
		joueur.setPseudo(pseudo);
		joueur.setMotDePasse(password);
		joueur.setEmail(email);
		joueur.setDateDeNaissance(dateDenaissance);
		return joueurDao.save(joueur);
	}

}
