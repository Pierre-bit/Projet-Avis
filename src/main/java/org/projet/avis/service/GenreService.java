package org.projet.avis.service;

import java.util.List;

import org.projet.avis.model.Genre;


public interface GenreService {

	Genre ajouterGenre(Genre genre);

	List<Genre> getAllGenres();

	Genre getGenre(Long id);

	boolean deleteGenre(long id);

	Genre udpateGenre(Long id, String nom);
}
