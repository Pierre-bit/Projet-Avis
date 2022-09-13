package org.projet.avis.service.impl;

import java.util.List;

import org.projet.avis.dao.GenreDao;
import org.projet.avis.model.Genre;
import org.projet.avis.service.GenreService;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {

	private final GenreDao genreDao;
	@Override
	public Genre ajouterGenre(Genre genre) {
		return genreDao.save(genre);
	}

	@Override
	public List<Genre> getAllGenres() {
		return genreDao.findAll();
	}

	@Override
	public Genre getGenre(Long id) {
		return genreDao.findById(id).orElse(null);
	}

	@Override
	public boolean deleteGenre(long id) {
		Genre genre = getGenre(id);
		if(genre == null)
		{
			return false;
		}
		else
		{
			genreDao.delete(genre);
			return true;
		}
	}

	@Override
	public Genre udpateGenre(Long id, String nom) {
		Genre genre = getGenre(id);
		genre.setNom(nom);
		return genreDao.save(genre);
	}

}
