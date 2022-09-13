package org.projet.avis.dto;

import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ModeleEconomiqueDto {

	String nom;
	
	List<Long>jeux;
}
