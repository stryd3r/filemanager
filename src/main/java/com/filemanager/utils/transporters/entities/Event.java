package com.filemanager.utils.transporters.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the events database table.
 * 
 */
@Entity
@Table(name = "events")
@NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eventId;

	@Column(name = "all_day")
	private byte allDay;

	private String color;

	private Timestamp endDate;

	private String observation;

	private Timestamp startDate;

	// bi-directional many-to-one association to Calendar
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "calendarId")
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