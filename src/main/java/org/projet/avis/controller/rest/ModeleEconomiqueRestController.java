package org.projet.avis.controller.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.projet.avis.dto.ModeleEconomiqueDto;
import org.projet.avis.model.Jeu;
import org.projet.avis.model.ModeleEconomique;
import org.projet.avis.service.JeuService;
import org.projet.avis.service.ModeleEconomiqueService;
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
public class ModeleEconomiqueRestController {

	
	ModeleEconomiqueService modeleEconomiqueService;
	JeuService jeuService;
	
	@PostMapping("/modeleEconomique")
	@ResponseStatus(HttpStatus.CREATED)
	public ModeleEconomique addModeleEconomique(@RequestBody ModeleEconomiqueDto modeleEconomiqueDto, BindingResult result)
	{
		return modeleEconomiqueService.ajouterModeleEconomique(dtoToModel(modeleEconomiqueDto));
	}
	
	@GetMapping("/modeleEconomique")
	public List<ModeleEconomique> getAllModeleEconomiquex()
	{
		return modeleEconomiqueService.getAllModeleEconomiques();
	}
	
	@GetMapping("/modeleEconomique/{id}")
	public ModeleEconomique getModeleEconomique(@PathVariable("id") Long id)
	{
		return modeleEconomiqueService.getModeleEconomique(id);
	}
	
	@PutMapping("/modeleEconomique/{id}")
	public ModeleEconomique updateModeleEconomique()
	{
		return null;
	}
	
	@DeleteMapping("/modeleEconomique/{id}")
	public boolean deleteModeleEconomique(@PathVariable("id") long id)
	{
		ModeleEconomique modeleEconomique = getModeleEconomique(null);
		if (modeleEconomique == null) {
			return false;
		} else {
			modeleEconomiqueService.deleteModeleEconomique(id);
			return true;
		}
	}
	
	private ModeleEconomique dtoToModel(ModeleEconomiqueDto modeleEconomiqueDto )
	{
		ModeleEconomique mde = new ModeleEconomique();
		mde.setNom(modeleEconomiqueDto.getNom());
		if (!CollectionUtils.isEmpty(modeleEconomiqueDto.getJeux()))
		{
			List<Jeu> jeux = new ArrayList<>();
			modeleEconomiqueDto.getJeux().forEach(item ->{
				jeux.add(jeuService.getJeu(item));
			});
			mde.setJeux(jeux);
		}
		return mde;
	}
	
	@ExceptionHandler(javax.validation.ConstraintViolationException.class)
    @ResponseStatus(code=HttpStatus.UNPROCESSABLE_ENTITY)
    public List<String> traiterDonneesInvalidesAvecDetails(ConstraintViolationException exception) {
        return exception.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
    }
}
