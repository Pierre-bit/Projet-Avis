package org.projet.avis.dto;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AvisDto {

	String description;
	
	LocalDateTime dateEnvoie;
	
	Float note;
	
	LocalDateTime dateModeration;
	
	Long joueur;
	
	Long moderateur;
}
