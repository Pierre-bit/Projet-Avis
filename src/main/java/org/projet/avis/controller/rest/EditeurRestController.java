package org.projet.avis.controller.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.projet.avis.dto.EditeurDto;
import org.projet.avis.model.Editeur;
import org.projet.avis.model.Jeu;
import org.projet.avis.service.EditeurService;
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
@CrossOrigin(origins = "http://localhost:4200")
public class EditeurRestController {

	EditeurService editeurService;
	JeuService jeuService;

	@PostMapping("/editeur")
	@ResponseStatus(HttpStatus.CREATED)
	public Editeur addEditeur(@RequestBody EditeurDto editeurDto, BindingResult result) {
		return editeurService.ajouterEditeur(dtoToModel(editeurDto));
	}

	@GetMapping("/editeur")
	public List<Editeur> getAllEditeurx() {
		return editeurService.getAllEditeurs();
	}

	@GetMapping("/editeur/{id}")
	public Editeur getEditeur(@PathVariable("id") Long id) {
		return editeurService.getEditeur(id);
	}

	@PutMapping("/editeur/{id}")
	public Editeur updateEditeur() {
		return null;
	}

	@DeleteMapping("/editeur/{id}")
	public boolean deleteEditeur(@PathVariable("id") long id) {
		Editeur editeur = getEditeur(null);
		if (editeur == null) {
			return false;
		} else {
			editeurService.deleteEditeur(id);
			return true;
		}
	}

	private Editeur dtoToModel(EditeurDto editeurDto) {
		Editeur ed = new Editeur();
		ed.setNom(editeurDto.getNom());
		if (!CollectionUtils.isEmpty(editeurDto.getJeux())) {
			List<Jeu> jeux = new ArrayList<>();
			editeurDto.getJeux().forEach(item -> {
				jeux.add(jeuService.getJeu(item));
			});
			ed.setJeux(jeux);
		}
		return ed;
	}

	@ExceptionHandler(javax.validation.ConstraintViolationException.class)
	@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
	public List<String> traiterDonneesInvalidesAvecDetails(ConstraintViolationException exception) {
		return exception.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
				.collect(Collectors.toList());
	}

}
