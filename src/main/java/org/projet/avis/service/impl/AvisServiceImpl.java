package org.projet.avis.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.projet.avis.dao.AvisDao;
import org.projet.avis.model.Avis;
import org.projet.avis.service.AvisService;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AvisServiceImpl implements AvisService {

	private AvisDao avisDao;

	@Override
	public Avis addAvis(Avis avis) {

		return avisDao.save(avis);
	}

	@Override
	public List<Avis> getAvis() {
		return avisDao.findAll();
	}

	@Override
	public Avis getAvis(long id) {
		return avisDao.findById(id).orElse(null);
	}

	@Override
	public Avis udpateAvis(Long id, String description, LocalDateTime dateEnvoie, float note,
			LocalDateTime dateModeration) {
		Avis avis = getAvis(id);
		avis.setDescription(description);
		avis.setDateEnvoie(dateEnvoie);
		avis.setNote(note);
		avis.setDateModeration(dateModeration);
		return avisDao.save(avis);
	}

	@Override
	public boolean deleteAvis(Long id) {
		Avis avis = getAvis(id);
		if (avis == null) {
			return false;
		} else {
			avisDao.delete(avis);
			return true;
		}

	}

}
