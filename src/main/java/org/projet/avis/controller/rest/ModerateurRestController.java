package org.projet.avis.controller.rest;

import java.util.List;

import org.projet.avis.model.Moderateur;
import org.projet.avis.service.ModerateurService;
import org.projet.avis.service.ModerateurService;
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
public class ModerateurRestController {

	@Autowired
	private ModerateurService moderateurService;
	
	@PostMapping("/moderateur")
	@ResponseStatus(HttpStatus.CREATED)
	public Moderateur ajoutermoderateur(@RequestBody Moderateur moderateur) {
		return moderateurService.ajouterModerateur(moderateur);
	}

	@GetMapping("/moderateur")
	public List<Moderateur> getAllmoderateurs() {
		return moderateurService.getAllModerateurs();
	}

	@GetMapping("moderateur/{id}")
	public Moderateur getmoderateur(@PathVariable("id") long id) {
		return moderateurService.getModerateur(id);
	}

	@PutMapping("/moderateur")
	public Moderateur updatemoderateur(@RequestBody Moderateur Moderateur) {
		return moderateurService.updateModerateur(0, null, null, null,null);
	}

	@DeleteMapping("moderateur/{id}")
	public boolean deletemoderateur(@PathVariable("id") long id) {
		Moderateur moderateur = getmoderateur(id);
		if (moderateur == null) {
			return false;
		} else {
			moderateurService.deleteModerateur(id);
			return true;
		}
	}
}
