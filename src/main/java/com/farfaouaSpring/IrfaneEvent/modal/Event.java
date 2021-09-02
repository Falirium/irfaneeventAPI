package com.farfaouaSpring.IrfaneEvent.modal;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true)
	private long id_event;

	@Column(nullable = false)
	private String titre;
	@Column(nullable = false)
	private Date dateDebut;
	@Column(nullable = false)	
	private Date dateFin;
	@Column(nullable = false)
	private String lieu;
	@Column(nullable = false)
	private int nbrPersonnes;
	@Column(nullable = false)	
	private String type;
	@Column(nullable = true)
	private String sponsor;
	
	//ManyToMany relationship ( participate )
	@ManyToMany(mappedBy = "participatedEvents")
	private List<User> participants;
	
	//ManyToOne relationship ( create )
	@ManyToOne
	@JoinColumn(name = "createdBy", referencedColumnName = "id_user")
	private User createdBy;


}
