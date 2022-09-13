package org.projet.avis.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UtilisateurDto {

	String nom;
	
	String prenom;
	
	String motDePasse;
	
	String email;
}
