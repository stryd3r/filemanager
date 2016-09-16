package com.filemanager.backend.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Events implements Serializable{

	private static final long serialVersionUID = -6994078432664785194L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String culoare;
	private String observatie;

	@Column(name = "start_date")
	private Timestamp startDate;

	@Column(name = "end_date")
	private Timestamp endDate;

	@Column(name = "all_day")
	private int allDay;

	@ManyToOne
	private Calendar calendar;

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCuloare() {
		return culoare;
	}

	public void setCuloare(String culoare) {
		this.culoare = culoare;
	}

	public String getObservatie() {
		return observatie;
	}

	public void setObservatie(String observatie) {
		this.observatie = observatie;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public int getAllDay() {
		return allDay;
	}

	public void setAllDay(int allDay) {
		this.allDay = allDay;
	}

}
