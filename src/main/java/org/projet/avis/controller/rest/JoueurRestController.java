package org.projet.avis.controller.rest;

import java.util.List;

import org.projet.avis.model.Joueur;
import org.projet.avis.service.JoueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@AllArgsConstructor
@RequestMapping("/api/")
@CrossOrigin("http://localhost:4200")
public class JoueurRestController {

	@Autowired
	private JoueurService joueurService;
	
	@PostMapping("/joueur")
	@ResponseStatus(HttpStatus.CREATED)
	public Joueur ajouterJoueur(@RequestBody Joueur joueur) {
		return joueurService.ajouterJoueur(joueur);
	}

	@GetMapping("/joueur")
	public List<Joueur> getAlljoueurs() {
		return joueurService.getAllJoueurs();
	}

	@GetMapping("joueur/{id}")
	public Joueur getjoueur(@PathVariable("id") long id) {
		return joueurService.getJoueur(id);
	}

	@PutMapping("/joueur")
	public Joueur updatejoueur(@RequestBody Joueur joueur) {
		return joueurService.updateJoueur(0, null, null, null,null);
	}

	@DeleteMapping("joueur/{id}")
	public boolean deletejoueur(@PathVariable("id") long id) {
		Joueur joueur = getjoueur(id);
		if (joueur == null) {
			return false;
		} else {
			joueurService.deleteJoueur(id);
			return true;
		}
	}
}
