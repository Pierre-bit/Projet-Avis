package org.projet.avis.service.impl;

import java.util.List;

import org.projet.avis.dao.ModerateurDao;
import org.projet.avis.model.Moderateur;
import org.projet.avis.service.ModerateurService;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModerateurServiceImpl implements ModerateurService {

	private final ModerateurDao moderateurDao;
	@Override
	public Moderateur ajouterModerateur(Moderateur moderateur) {
		return moderateurDao.save(moderateur);
	}

	@Override
	public List<Moderateur> getAllModerateurs() {
		return moderateurDao.findAll();
	}

	@Override
	public Moderateur getModerateur(Long id) {
		return moderateurDao.findById(id).orElse(null);
	}

	@Override
	public boolean deleteModerateur(long id) {
		Moderateur moderateur = getModerateur(id);
		if (moderateur == null)
		{
			return false;
		}
		moderateurDao.delete(moderateur);
		return true;
	}

	@Override
	public Moderateur updateModerateur(long id, String pseudo, String password, String email, String numero) {
		Moderateur moderateur = getModerateur(id);
		moderateur.setPseudo(pseudo);
		moderateur.setMotDePasse(password);
		moderateur.setEmail(email);
		moderateur.setNumeroDeTelephone(numero);
		return moderateurDao.save(moderateur);
	}

}
