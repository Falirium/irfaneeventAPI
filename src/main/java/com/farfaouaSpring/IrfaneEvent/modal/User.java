package com.farfaouaSpring.IrfaneEvent.modal;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_user;
	private String nom;
	private String prenom;
	private String cin;
	private String metier;
	private String etablissement;
	private String anneeEtude;
	private String username;
	private String password;
	private float score;
	
	
	//ManyToMany relationship ( participate )
	@ManyToMany
	@JoinTable(
			name="user_event_participation",
			joinColumns = @JoinColumn(name="id_user_participation" , referencedColumnName = "id_user"), 
			inverseJoinColumns = @JoinColumn(name="id_event_participation", referencedColumnName = "id_event")
			)
	private List<Event> participatedEvents;
	
	//OneToMany relationship ( create )
	@OneToMany(mappedBy = "createdBy")
	private List<Event> createdEvents;
}
