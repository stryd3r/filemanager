package com.filemanager.utils.transporters.dto;

import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the calendar database table.
 * 
 */
public class CalendarDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private int calendarId;

	private DoctorsDto doctor;

	private List<EventDto> events;

	public CalendarDto() {
	}

	public int getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(int calendarId) {
		this.calendarId = calendarId;
	}

	public DoctorsDto getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorsDto doctor) {
		this.doctor = doctor;
	}

	public List<EventDto> getEvents() {
		return this.events;
	}

	public void setEvents(List<EventDto> events) {
		this.events = events;
	}

	public EventDto addEvent(EventDto event) {
		getEvents().add(event);
		event.setCalendar(this);

		return event;
	}

	public EventDto removeEvent(EventDto event) {
		getEvents().remove(event);
		event.setCalendar(null);

		return event;
	}

}