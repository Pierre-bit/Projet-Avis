package org.projet.avis.controller.rest;

import java.util.List;

import org.projet.avis.Exception.UtilisateurExistantException;
import org.projet.avis.dao.UtilisateurDao;
import org.projet.avis.model.Utilisateur;
import org.projet.avis.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/")
@CrossOrigin("http://localhost:4200")
@Validated
public class UtilisateurRestController {

	@Autowired
	UtilisateurService utilisateurService;

	@PostMapping("/user")
	@ResponseStatus(HttpStatus.CREATED)
	public Utilisateur ajouterUser(@RequestBody Utilisateur user) {
		return utilisateurService.ajouterUser(user);
	}

	@GetMapping("/user")
	public List<Utilisateur> getAllUsers() {
		return utilisateurService.getAllUsers();
	}

	@GetMapping("user/{id}")
	public Utilisateur getUser(@PathVariable("id") long id) {
		return utilisateurService.getUser(id);
	}

	@PutMapping("/user")
	public Utilisateur updateUser(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.updateUser(0, null, null, null);
	}

	@DeleteMapping("user/{id}")
	public boolean deleteUser(@PathVariable("id") long id) {
		Utilisateur utilisateur = getUser(id);
		if (utilisateur == null) {
			return false;
		} else {
			utilisateurService.deleteUser(id);
			return true;
		}
	}

	@GetMapping("user/all")
	public Page<Utilisateur> getUtilisateurs(@PageableDefault(sort="id")Pageable pageable, @RequestParam(required = false) String filter) {
		return utilisateurService.getUtilisateurs(pageable, filter);
	}

}
