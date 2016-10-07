package com.filemanager.backend.service.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.dto.simple.EventDto;

public interface EventService {

	int insertEvent(EventDto event);

	boolean updateEvent(EventDto event);

	List<EventDto> getEvents();

	public EventDto getEventById(int eventId);

	boolean removeEvent(int eventId);

}
