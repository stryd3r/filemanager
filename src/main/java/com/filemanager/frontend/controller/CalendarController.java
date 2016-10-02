package com.filemanager.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filemanager.backend.service.interfaces.CalendarService;
import com.filemanager.utils.transporters.entities.Calendar;
import com.filemanager.utils.transporters.entities.Event;

@RestController
public class CalendarController {

	@Autowired
	private CalendarService service;

	@RequestMapping(value = "/addCalendarForDoctor", produces = "application/json")
	public Calendar addCalendarForDoctor(int doctorId) {
		return service.addCalendarForDoctor(doctorId);
	}

	@RequestMapping(value = "/deleteCalendar", produces = "application/json")
	public boolean deleteCalendar(Calendar calendar) {
		return service.deleteCalendar(calendar);
	}

	@RequestMapping(value = "/addEvent", produces = "application/json")
	public Event addEvent(Event event) {
		return service.addEvent(event);
	}

	@RequestMapping(value = "/updateEvent", produces = "application/json")
	public boolean updateEvent(Event event) {
		return service.updateEvent(event);
	}

	@RequestMapping(value = "/getEvents", produces = "application/json")
	public List<Event> getEvents(int calendarId) {
		return service.getEvents(calendarId);
	}

	@RequestMapping(value = "/getEventById", produces = "application/json")
	public Event getEventById(int eventId) {
		return service.getEventById(eventId);
	}

	@RequestMapping(value = "/removeEvent", produces = "application/json")
	public boolean removeEvent(Event event) {
		return service.removeEvent(event);
	}

}
