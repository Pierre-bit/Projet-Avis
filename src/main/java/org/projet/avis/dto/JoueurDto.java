package org.projet.avis.dto;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JoueurDto {

	String nom;
	
	String prenom;
	
	String email;
	
	String motDePasse;
	
	LocalDate dateDeNaissance;
	
	
	
}
