package org.projet.avis.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ModerateurDto {

	String nom;
	
	String prenom;
	
	String email;
	
	String motDePasse; 
	
	String numeroDeTelephone;
}
