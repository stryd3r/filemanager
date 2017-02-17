package com.filemanager.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filemanager.backend.service.interfaces.EventService;
import com.filemanager.utils.transporters.dto.simple.EventDto;

@RestController
@RequestMapping("/router")
public class EventController {

	@Autowired
	private EventService service;

	@RequestMapping(value = "/insertEvent", produces = "application/json")
	public int insertEvent(EventDto event) {
		return service.insertEvent(event);
	}

	@RequestMapping(value = "/updateEvent", produces = "application/json")
	public boolean updateEvent(EventDto event) {
		return service.updateEvent(event);
	}

	@RequestMapping(value = "/getEvents", produces = "application/json")
	public List<EventDto> getEvents() {
		return service.getEvents();
	}

	@RequestMapping(value = "/getEventById", produces = "application/json")
	public EventDto getEventById(int eventId) {
		return service.getEventById(eventId);
	}

	@RequestMapping(value = "/removeEvent", produces = "application/json", method=RequestMethod.DELETE)
	public boolean removeEvent(int eventId) {
		return service.removeEvent(eventId);
	}
}
