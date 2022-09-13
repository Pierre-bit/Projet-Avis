package org.projet.avis.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class Avis {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;
	@NonNull
	@NotNull(message =" Veuillez décrire votre avis")
	private String description;
	@NotNull
	@NonNull
	private LocalDateTime dateEnvoie;
	@NonNull
	@NotNull(message = "merci de mettre une note")
	private Float note;
	@NotNull
	@NonNull
	private LocalDateTime dateModeration;
	@NotNull
	@NonNull
	@ManyToOne
	private Joueur joueur;
	@NotNull
	@NonNull
	@ManyToOne
	private Moderateur moderateur;
	
}
