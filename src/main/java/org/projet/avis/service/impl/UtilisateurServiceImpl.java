package org.projet.avis.service.impl;

import java.util.List;

import org.projet.avis.Exception.UtilisateurExistantException;
import org.projet.avis.dao.UtilisateurDao;
import org.projet.avis.model.Utilisateur;
import org.projet.avis.service.UtilisateurService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {

	private final UtilisateurDao utilisateurDao;

	@Override
	public Utilisateur ajouterUser(Utilisateur user) {
		if (UtilisateurDao.findByEmail(user.getEmail() != null)) {
			throw new UtilisateurExistantException("Email exists");
		}
		return utilisateurDao.save(user);
	}

	@Override
	public List<Utilisateur> getAllUsers() {
		return utilisateurDao.findAll();
	}

	@Override
	public Utilisateur getUser(Long id) {
		return utilisateurDao.findById(id).orElse(null);
	}

	@Override
	public Utilisateur updateUser(long id, String pseudo, String password, String email) {
		Utilisateur utilisateur = getUser(id);
		utilisateur.setPseudo(pseudo);
		utilisateur.setMotDePasse(password);
		utilisateur.setEmail(email);
		return utilisateurDao.save(utilisateur);
	}

	@Override
	public boolean deleteUser(long id) {
		Utilisateur utilisateur = getUser(id);
		if (utilisateur == null) {
			return false;
		} else {
			utilisateurDao.delete(utilisateur);
			return true;
		}
	}

	@Override
	public Page<Utilisateur> getUtilisateurs(Pageable pageable, String filter) {
		return utilisateurDao.findByPseudoStartingWithIgnoreCase(pageable, filter);
	}

}
