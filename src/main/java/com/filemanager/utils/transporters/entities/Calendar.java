package com.filemanager.utils.transporters.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	private int calendarId;

	// bi-directional many-to-one association to Doctori
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctorId")
	@Cascade(value = { CascadeType.ALL})
	@JsonBackReference
	private Doctor doctor;

	// bi-directional many-to-one association to Event
	@OneToMany(mappedBy = "calendar")
	@Cascade(value = { CascadeType.ALL})
	private List<Event> events;

	public Calendar() {
	}

	public int getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(int calendarId) {
		this.calendarId = calendarId;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
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