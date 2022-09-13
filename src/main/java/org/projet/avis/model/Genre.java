package org.projet.avis.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@RequiredArgsConstructor
@Entity
public class Genre {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@NonNull
	@NotNull
	private String nom;
	
	@NonNull
	@NotNull
	@JsonIgnore
	@OneToMany(mappedBy = "genre")
	@ToString.Exclude
	private List<Jeu> jeux;
	
}
