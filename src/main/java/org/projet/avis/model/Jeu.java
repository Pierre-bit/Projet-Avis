package org.projet.avis.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Jeu {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NonNull
	@NotNull
	private String nom;
	@NonNull
	@NotNull
	private String description;
	@NonNull
	@NotNull
	private LocalDateTime dateSortie = LocalDateTime.now();
	@NonNull
	@NotNull
	private String image;
	@NonNull
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	private Classification classification;
	@NonNull
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	private Genre genre;
	@NonNull
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	private Editeur editeur;
	@ManyToMany
	@ToString.Exclude
	private List<Plateforme> plateformes;
	@NotNull
	@NonNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private ModeleEconomique modeleEconomique;
	@NotNull
	@NonNull
	@ManyToOne
	private Moderateur moderateur;
}
