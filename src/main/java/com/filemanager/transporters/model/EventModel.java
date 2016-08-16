package com.filemanager.transporters.model;

import java.security.Timestamp;

public class EventModel {

	private int id;
	private int idCalendar;
	private String observatie;
	private Timestamp startDate;
	private Timestamp endDate;
	private boolean allDay;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCalendar() {
		return idCalendar;
	}

	public void setIdCalendar(int idCalendar) {
		this.idCalendar = idCalendar;
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

	public boolean isAllDay() {
		return allDay;
	}

	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}

}
