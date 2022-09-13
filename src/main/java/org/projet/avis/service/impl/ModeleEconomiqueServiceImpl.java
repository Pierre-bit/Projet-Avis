package org.projet.avis.service.impl;

import java.util.List;

import org.projet.avis.dao.ModeleEconomiqueDao;
import org.projet.avis.model.ModeleEconomique;
import org.projet.avis.service.ModeleEconomiqueService;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModeleEconomiqueServiceImpl implements ModeleEconomiqueService {

	private final ModeleEconomiqueDao modeleEconomiqueDao;
	@Override
	public ModeleEconomique ajouterModeleEconomique(ModeleEconomique modeleEconomique) {
		return modeleEconomiqueDao.save(modeleEconomique);
	}

	@Override
	public List<ModeleEconomique> getAllModeleEconomiques() {
		return modeleEconomiqueDao.findAll();
	}

	@Override
	public ModeleEconomique getModeleEconomique(Long id) {
		return modeleEconomiqueDao.findById(id).orElse(null);
	}

	@Override
	public boolean deleteModeleEconomique(long id) {
		ModeleEconomique modeleEconomique = getModeleEconomique(id);
		if (modeleEconomique == null)
		{
			return false;
		}
		modeleEconomiqueDao.delete(modeleEconomique);
		return true;
	}

	@Override
	public ModeleEconomique udpateModeleEconomique(Long id, String nom) {
		ModeleEconomique modeleEconomique = getModeleEconomique(id);
		modeleEconomique.setNom(nom);
		return modeleEconomiqueDao.save(modeleEconomique);

	}

}
