package org.projet.avis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Inheritance
public class Utilisateur {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	protected Long id;
	@NonNull
	@NotNull(message = "Indiquez votre pseudo")
	protected String pseudo;
	@NonNull
	@NotNull(message = "Indiquez votre mot de passe")
	protected String motDePasse;
	@NonNull
	@Email
	protected String email;
}
