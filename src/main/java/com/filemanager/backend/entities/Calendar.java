package com.filemanager.backend.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Calendar  implements Serializable{

	private static final long serialVersionUID = 4152337040007659043L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToOne(mappedBy="calendar")
	private Doctori doctor;

	@OneToMany(mappedBy="calendar",fetch=FetchType.LAZY)
	private List<Events> events;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Doctori getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctori doctor) {
		this.doctor = doctor;
	}

	public List<Events> getEvents() {
		return events;
	}

	public void setEvents(List<Events> events) {
		this.events = events;
	}

}
