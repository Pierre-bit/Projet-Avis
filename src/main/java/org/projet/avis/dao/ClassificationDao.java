package org.projet.avis.dao;

import org.projet.avis.model.Classification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassificationDao extends JpaRepository<Classification, Long> {

}
