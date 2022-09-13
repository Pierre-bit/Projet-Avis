package org.projet.avis.controller.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.projet.avis.dto.PlateformeDto;
import org.projet.avis.model.Jeu;
import org.projet.avis.model.Plateforme;
import org.projet.avis.service.JeuService;
import org.projet.avis.service.PlateformeService;
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
public class PlateformeRestController {
	
	
	PlateformeService plateformeService;
	JeuService jeuService;
	
	
	@PostMapping("/plateforme")
	@ResponseStatus(HttpStatus.CREATED)
	public Plateforme addPlateforme(@RequestBody PlateformeDto plateformeDto, BindingResult result)
	{
		return plateformeService.ajouterPlateforme(dtoToModel(plateformeDto));
	}
	
	@GetMapping("/plateforme")
	public List<Plateforme> getAllPlateformex()
	{
		return plateformeService.getAllPlateformes();
	}
	
	@GetMapping("/plateforme/{id}")
	public Plateforme getPlateforme(@PathVariable("id") Long id)
	{
		return plateformeService.getPlateforme(id);
	}
	
	@PutMapping("/plateforme/{id}")
	public Plateforme updatePlateforme()
	{
		return null;
	}
	
	@DeleteMapping("/plateforme/{id}")
	public boolean deletePlateforme(@PathVariable("id") long id)
	{
		Plateforme plateforme = getPlateforme(null);
		if (plateforme == null) {
			return false;
		} else {
			plateformeService.deletePlateforme(id);
			return true;
		}
	}
	
	private Plateforme dtoToModel(PlateformeDto plateformeDto)
	{
		Plateforme pl = new Plateforme();
		pl.setNom(plateformeDto.getNom());
		if (!CollectionUtils.isEmpty(plateformeDto.getJeux()))
		{
			List<Jeu> jeux = new ArrayList<>();
			plateformeDto.getJeux().forEach(item ->{
				jeux.add(jeuService.getJeu(item));
			});
			pl.setJeux(jeux);
		}
		return pl;
	}
	
	@ExceptionHandler(javax.validation.ConstraintViolationException.class)
    @ResponseStatus(code=HttpStatus.UNPROCESSABLE_ENTITY)
    public List<String> traiterDonneesInvalidesAvecDetails(ConstraintViolationException exception) {
        return exception.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
    }
	

}
