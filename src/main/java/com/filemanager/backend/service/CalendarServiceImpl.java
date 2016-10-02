package com.filemanager.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filemanager.backend.dao.interfaces.CalendarDao;
import com.filemanager.backend.service.interfaces.CalendarService;
import com.filemanager.utils.transporters.entities.Calendar;
import com.filemanager.utils.transporters.entities.Event;

@Service
@Transactional(rollbackFor = Exception.class)
public class CalendarServiceImpl implements CalendarService {

	@Autowired
	private CalendarDao dao;

	@Override
	public Calendar addCalendarForDoctor(int doctorId) {

		return dao.addCalendarForDoctor(doctorId);
	}

	@Override
	public boolean deleteCalendar(Calendar calendar) {

		return dao.deleteCalendar(calendar);
	}

	@Override
	public Event addEvent(Event event) {

		return dao.addEvent(event);
	}

	@Override
	public boolean updateEvent(Event event) {

		return dao.updateEvent(event);
	}

	@Override
	public boolean removeEvent(Event event) {

		return dao.removeEvent(event);
	}

	@Override
	public List<Event> getEvents(int calendarId) {

		return dao.getEvents(calendarId);
	}

	@Override
	public Event getEventById(int eventId) {

		return dao.getEventById(eventId);
	}

}
