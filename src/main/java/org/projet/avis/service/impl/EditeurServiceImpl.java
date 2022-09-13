package org.projet.avis.service.impl;

import java.util.List;

import org.projet.avis.dao.EditeurDao;
import org.projet.avis.model.Editeur;
import org.projet.avis.service.EditeurService;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EditeurServiceImpl implements EditeurService {

	private final EditeurDao editeurDao;
	@Override
	public Editeur ajouterEditeur(Editeur editeur) {
		return editeurDao.save(editeur);
	}

	@Override
	public List<Editeur> getAllEditeurs() {
		return editeurDao.findAll();
	}

	@Override
	public Editeur getEditeur(Long id) {
		return editeurDao.findById(id).orElse(null);
	}

	@Override
	public boolean deleteEditeur(long id) {
		Editeur editeur = getEditeur(id);
		if(editeur == null)
		{
			return false;
		}
		else
		{
			editeurDao.delete(editeur);
			return true;
		}
	}

	@Override
	public Editeur udpateEditeur(Long id, String nom) {
		Editeur editeur = getEditeur(id);
		editeur.setNom(nom);
		return editeurDao.save(editeur);
	}

}
