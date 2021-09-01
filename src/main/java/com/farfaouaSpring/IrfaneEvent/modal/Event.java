package com.farfaouaSpring.IrfaneEvent.modal;

import java.util.Date;
import java.util.List;

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
	private long id_event;
	private String titre;
	private Date dateDebut;
	private Date dateFin;
	private String lieu;
	private int nbrPersonnes;
	private String type;
	private List<String> sponsor;
	
	//ManyToMany relationship ( participate )
	@ManyToMany(mappedBy = "participatedEvents")
	private List<User> participants;
	
	//ManyToOne relationship ( create )
	@ManyToOne
	@JoinColumn(name = "createdBy", referencedColumnName = "id_user")
	private User createdBy;
}
