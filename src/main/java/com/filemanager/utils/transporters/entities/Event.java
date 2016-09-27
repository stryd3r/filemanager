package com.filemanager.utils.transporters.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * The persistent class for the events database table.
 * 
 */
@Entity
@NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eventId;

	@Column(name = "allDay")
	private byte allDay;

	private String color;

	private Timestamp endDate;

	private String observation;

	private Timestamp startDate;

	// bi-directional many-to-one association to Calendar
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "calendarId")
	@Cascade(value = { CascadeType.ALL})
	@JsonBackReference
	private Calendar calendar;

	public Event() {
	}

	public byte getAllDay() {
		return this.allDay;
	}

	public void setAllDay(byte allDay) {
		this.allDay = allDay;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Calendar getCalendar() {
		return this.calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

}