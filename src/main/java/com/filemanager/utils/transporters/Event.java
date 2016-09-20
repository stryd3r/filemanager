package com.filemanager.utils.transporters;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.sql.Timestamp;


/**
 * The persistent class for the events database table.
 * 
 */
@Entity
@Table(name="events")
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="all_day")
	private byte allDay;

	private String culoare;

	@Column(name="end_date")
	private Timestamp endDate;

	private String observatie;

	@Column(name="start_date")
	private Timestamp startDate;

	//bi-directional many-to-one association to Calendar
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_calendar")
	@JsonBackReference(value="eveCal")
	private Calendar calendar;

	public Event() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getAllDay() {
		return this.allDay;
	}

	public void setAllDay(byte allDay) {
		this.allDay = allDay;
	}

	public String getCuloare() {
		return this.culoare;
	}

	public void setCuloare(String culoare) {
		this.culoare = culoare;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getObservatie() {
		return this.observatie;
	}

	public void setObservatie(String observatie) {
		this.observatie = observatie;
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

}