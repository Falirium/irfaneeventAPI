package com.farfaouaSpring.IrfaneEvent.modal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true)
	private long id_user;
	@Column(nullable = false)
	private String nom;
	@Column(nullable = false)
	private String prenom;
	@Column(nullable = false)
	private String cin;
	@Column(nullable = true)
	private String metier;
	@Column(nullable = true)
	private String etablissement;
	@Column(nullable = true)
	private String anneeEtude;
	@Column(nullable = true)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private float score;
	
	
	//ManyToMany relationship ( participate )
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="user_event_participation",
			joinColumns = @JoinColumn(name="id_user_participation" , referencedColumnName = "id_user"), 
			inverseJoinColumns = @JoinColumn(name="id_event_participation", referencedColumnName = "id_event")
			)
	private List<Event> participatedEvents;
	
	//OneToMany relationship ( create )
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
	private List<Event> createdEvents;
}
