package org.projet.avis.controller.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.projet.avis.dto.GenreDto;
import org.projet.avis.model.Genre;
import org.projet.avis.model.Jeu;
import org.projet.avis.service.GenreService;
import org.projet.avis.service.JeuService;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins="http://localhost:4200")
@AllArgsConstructor
public class GenreRestController {

	
	GenreService genreService;
	JeuService jeuService;
	
	@PostMapping("/genre")
	@ResponseStatus(HttpStatus.CREATED)
	public Genre addGenre(@RequestBody GenreDto genreDto, BindingResult result)
	{
		return genreService.ajouterGenre(dtoToModel(genreDto));
	}
	
	@GetMapping("/genre")
	public List<Genre> getAllGenrex()
	{
		return genreService.getAllGenres();
	}
	
	@GetMapping("/Genre/{id}")
	public Genre getGenre(@PathVariable("id") Long id)
	{
		return genreService.getGenre(id);
	}
	
	@PutMapping("/genre/{id}")
	public Genre updateGenre()
	{
		return null;
	}
	
	@DeleteMapping("/genre/{id}")
	public boolean deleteGenre(@PathVariable("id") long id)
	{
		Genre genre = getGenre(null);
		if (genre == null) {
			return false;
		} else {
			genreService.deleteGenre(id);
			return true;
		}
	}
	
	private Genre dtoToModel(GenreDto genreDto)
	{
		Genre g = new Genre();
		g.setNom(genreDto.getNom());
		if (!CollectionUtils.isEmpty(genreDto.getJeux()))
		{
			List<Jeu> jeux = new ArrayList<>();
			genreDto.getJeux().forEach(item ->{
				jeux.add(jeuService.getJeu(item));
			});
			g.setJeux(jeux);
		}
		return g;
	}
	
	@ExceptionHandler(javax.validation.ConstraintViolationException.class)
    @ResponseStatus(code=HttpStatus.UNPROCESSABLE_ENTITY)
    public List<String> traiterDonneesInvalidesAvecDetails(ConstraintViolationException exception) {
        return exception.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
    }
}
