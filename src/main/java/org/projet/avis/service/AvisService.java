package org.projet.avis.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.projet.avis.model.Avis;

public interface AvisService {
	
	
	List<Avis> getAvis();
	
	Avis getAvis(long id);
	
	Avis udpateAvis(Long id, String description,LocalDateTime dateEnvoie
			, float note, LocalDateTime dateModeration);
	
	boolean deleteAvis(Long id);

	Avis addAvis(Avis avis);

}
