package com.filemanager.utils.transporters;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the calendar database table.
 * 
 */
@Entity
@NamedQuery(name="Calendar.findAll", query="SELECT c FROM Calendar c")
public class Calendar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Doctori
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_doctor")
	private Doctori doctori;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="calendar")
	private List<Event> events;

	public Calendar() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Doctori getDoctori() {
		return this.doctori;
	}

	public void setDoctori(Doctori doctori) {
		this.doctori = doctori;
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