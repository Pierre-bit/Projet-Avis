package org.projet.avis.service.impl;

import java.util.List;

import org.projet.avis.dao.ClassificationDao;
import org.projet.avis.model.Classification;
import org.projet.avis.service.ClassificationService;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClassificationServiceImpl implements ClassificationService {

	private final ClassificationDao classificationDao;
	@Override
	public Classification ajouterClassification(Classification classification) {
		return classificationDao.save(classification);
	}

	@Override
	public List<Classification> getAllClassifications() {
		return classificationDao.findAll();
	}

	@Override
	public Classification getClassification(Long id) {
		return classificationDao.findById(id).orElse(null);
	}

	@Override
	public boolean deleteClassification(long id) {
		Classification classification = getClassification(id);
		if(classification == null)
		{
			return false;
		}
		else
		{
			classificationDao.delete(classification);
			return true;
		}
	}

	@Override
	public Classification udpateClassification(Long id, String nom) {
		Classification classification = getClassification(id);
		classification.setNom(nom);
		return classificationDao.save(classification);
	}

}
