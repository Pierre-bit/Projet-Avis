package org.projet.avis.service.impl;

import java.util.List;

import org.projet.avis.dao.PlateformeDao;
import org.projet.avis.model.Plateforme;
import org.projet.avis.service.PlateformeService;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PlateformeServiceImpl implements PlateformeService {

	private final PlateformeDao plateformeDao;
	@Override
	public Plateforme ajouterPlateforme(Plateforme plateforme) {
		return plateformeDao.save(plateforme);
	}

	@Override
	public List<Plateforme> getAllPlateformes() {
		return plateformeDao.findAll();
	}

	@Override
	public Plateforme getPlateforme(Long id) {
		return plateformeDao.findById(id).orElse(null);
	}

	@Override
	public boolean deletePlateforme(long id) {
		Plateforme plateforme = getPlateforme(id);
		if( plateforme == null)
		{
			return false;
		}
		plateformeDao.delete(plateforme);
		return true;
	}

	@Override
	public Plateforme udpatePlateforme(Long id, String nom) {
		Plateforme plateforme = getPlateforme(id);
		plateforme.setNom(nom);
		return plateformeDao.save(plateforme);
	}

}
