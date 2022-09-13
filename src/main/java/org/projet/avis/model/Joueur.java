package org.projet.avis.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Joueur extends Utilisateur{

	private LocalDate dateDeNaissance;
	@NotNull
	@NonNull
	@OneToMany(mappedBy = "joueur")
	@ToString.Exclude()
	private List<Avis> avis;
}
