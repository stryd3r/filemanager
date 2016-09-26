package com.filemanager.utils.transporters.dto;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * The persistent class for the events database table.
 * 
 */
public class EventDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private int eventId;

	private byte allDay;

	private String color;

	private Timestamp endDate;

	private String observation;

	private Timestamp startDate;

	private CalendarDto calendar;

	public EventDto() {
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

	public CalendarDto getCalendar() {
		return this.calendar;
	}

	public void setCalendar(CalendarDto calendar) {
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