package org.projet.avis.dao;

import org.projet.avis.model.Avis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvisDao extends JpaRepository<Avis,Long> {

}
