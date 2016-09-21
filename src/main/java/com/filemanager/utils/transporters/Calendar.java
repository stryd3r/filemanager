package com.filemanager.utils.transporters;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the calendar database table.
 * 
 */
@Entity
@NamedQuery(name = "Calendar.findAll", query = "SELECT c FROM Calendar c")
public class Calendar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_calendar")
	private int idCalendar;

	// bi-directional many-to-one association to Doctori
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_doctor")
	private Doctori doctor;

	// bi-directional many-to-one association to Event
	@OneToMany(mappedBy = "calendar")
	private List<Event> events;

	public Calendar() {
	}

	public int getIdCalendar() {
		return this.idCalendar;
	}

	public void setIdCalendar(int idCalendar) {
		this.idCalendar = idCalendar;
	}

	public Doctori getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctori doctor) {
		this.doctor = doctor;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setCalendar(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setCalendar(null);

		return event;
	}

}