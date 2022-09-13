package org.projet.avis.controller.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.projet.avis.dto.ClassificationDto;
import org.projet.avis.model.Classification;
import org.projet.avis.model.Jeu;
import org.projet.avis.service.ClassificationService;
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
@AllArgsConstructor
@CrossOrigin(origins="http://localhost:4200")
public class ClassificationRestController {
	

	ClassificationService classificationService;
	JeuService jeuService;
	
	
	@PostMapping("/classification")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Classification addClassification(@RequestBody ClassificationDto classificationDto, BindingResult result)
	{
		return classificationService.ajouterClassification(dtoToModel(classificationDto));
	}
	
	@GetMapping("/classification")
	public List<Classification> getAllClassificationx()
	{
		return classificationService.getAllClassifications();
	}
	
	@GetMapping("/classification/{id}")
	public Classification getClassification(@PathVariable("id") Long id)
	{
		return classificationService.getClassification(id);
	}
	
	@PutMapping("/classification/{id}")
	public Classification updateClassification()
	{
		return null;
	}
	
	@DeleteMapping("/classification/{id}")
	public boolean deleteClassification(@PathVariable("id") long id)
	{
		Classification classification = getClassification(null);
		if (classification == null) {
			return false;
		} else {
			classificationService.deleteClassification(id);
			return true;
		}
	}
	
	private Classification dtoToModel(ClassificationDto classificationDto)
	{
		Classification cl = new Classification();
		cl.setNom(classificationDto.getNom());
		if (!CollectionUtils.isEmpty(classificationDto.getJeux()))
		{
			List<Jeu> jeux = new ArrayList<>();
			classificationDto.getJeux().forEach(item ->{
				jeux.add(jeuService.getJeu(item));
			});
			cl.setJeux(jeux);
		}
		return cl;
	}
	
	@ExceptionHandler(javax.validation.ConstraintViolationException.class)
    @ResponseStatus(code=HttpStatus.UNPROCESSABLE_ENTITY)
    public List<String> traiterDonneesInvalidesAvecDetails(ConstraintViolationException exception) {
        return exception.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
    }

}
