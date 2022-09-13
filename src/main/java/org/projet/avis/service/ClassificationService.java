package org.projet.avis.service;

import java.util.List;

import org.projet.avis.model.Classification;

public interface ClassificationService {

	Classification ajouterClassification(Classification classification);
	
	List<Classification> getAllClassifications();
	
	Classification getClassification(Long id);
	
	boolean deleteClassification(long id);
	
	Classification udpateClassification(Long id,String nom);
}
