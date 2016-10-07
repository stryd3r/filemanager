package com.filemanager.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filemanager.backend.dao.interfaces.EventDao;
import com.filemanager.backend.service.interfaces.EventService;
import com.filemanager.utils.transporters.dto.simple.EventDto;

@Service
@Transactional(rollbackFor = Exception.class)
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDao dao;

	@Override
	public int insertEvent(EventDto event) {
		return dao.insertEvent(event);
	}

	@Override
	public boolean updateEvent(EventDto event) {
		return dao.updateEvent(event);
	}

	@Override
	public List<EventDto> getEvents() {
		return dao.getEvents();
	}

	@Override
	public EventDto getEventById(int eventId) {
		return dao.getEventById(eventId);
	}

	@Override
	public boolean removeEvent(int eventId) {
		return dao.removeEvent(eventId);
	}
}
