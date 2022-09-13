package org.projet.avis.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.projet.avis.Exception.JeuExistantException;
import org.projet.avis.dao.JeuDao;
import org.projet.avis.model.Jeu;
import org.projet.avis.service.JeuService;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JeuServiceImpl implements JeuService {

	private JeuDao jeuDao;

	@Override
	public Jeu addJeu(Jeu jeu) {
//		if (jeuDao.findByNom(jeu.getNom() != null)) {
//			throw new JeuExistantException("jeu existe déja");
//		}
		return jeuDao.save(jeu);
	}

	@Override
	public List<Jeu> getAllJeux() {
		return jeuDao.findAll();
	}

	@Override
	public Jeu getJeu(Long id) {
		return jeuDao.findById(id).orElse(null);
	}

	@Override
	public Jeu updateJeu(long id, String nom, String description, LocalDate dateSortie, String image) {
		Jeu jeu = getJeu(id);
		jeu.setDescription(description);
		return jeuDao.save(jeu);
	}

	@Override
	public boolean deleteJeu(Long id) {
		Jeu jeu = getJeu(id);
		if (jeu == null) {
			return false;
		} else {
			jeuDao.delete(jeu);
			return true;
		}
	}

}
