package org.projet.avis.dao;

import org.projet.avis.model.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoueurDao extends JpaRepository<Joueur, Long> {

}
