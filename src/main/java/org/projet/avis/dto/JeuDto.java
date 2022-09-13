package org.projet.avis.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JeuDto {
	
	String nom;
	
	String description;
	
	LocalDateTime dateSortie;
	
	String image;
	
	Long classification;
	
	Long genre;
	
	Long editeur;
	
	List<Long>plateformes;
	
	Long modeleEconomique;
	
	Long moderateur;
	

}
