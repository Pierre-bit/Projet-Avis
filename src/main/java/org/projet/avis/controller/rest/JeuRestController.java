package org.projet.avis.controller.rest;

import java.util.List;

import org.projet.avis.model.Jeu;
import org.projet.avis.service.JeuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@Validated
public class JeuRestController {
	
	
	@Autowired
	private JeuService jeuService;
	
	@PostMapping("/jeu")
	@ResponseStatus(HttpStatus.CREATED)
	public Jeu addJeu(@RequestBody Jeu jeu)
	{
		return jeuService.addJeu(jeu);
	}
	
	@GetMapping("/jeu")
	public List<Jeu> getAllJeux()
	{
		return jeuService.getAllJeux();
	}
	
	@GetMapping("/jeu/{id}")
	public Jeu getJeu(@PathVariable("id") Long id)
	{
		return jeuService.getJeu(id);
	}
	
	@PutMapping("/jeu/{id}")
	public Jeu updateJeu()
	{
		return null;
	}
	
	@DeleteMapping("/jeu/{id}")
	public boolean deleteJeu(@PathVariable("id") long id)
	{
		Jeu jeu = getJeu(id);
		if (jeu == null) {
			return false;
		} else {
			jeuService.deleteJeu(id);
			return true;
		}
	}
	
	
}
