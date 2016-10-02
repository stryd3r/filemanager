package com.filemanager.backend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.filemanager.backend.dao.interfaces.CalendarDao;
import com.filemanager.utils.transporters.entities.Calendar;
import com.filemanager.utils.transporters.entities.Doctor;
import com.filemanager.utils.transporters.entities.Event;

@Repository
@SuppressWarnings("unchecked")
public class CalendarDaoImpl implements CalendarDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Calendar addCalendarForDoctor(int doctorId) {
		Calendar calendar = new Calendar();
		calendar.setDoctor(new Doctor(doctorId));
		sessionFactory.getCurrentSession().persist(calendar);

		return calendar;
	}

	@Override
	public boolean deleteCalendar(Calendar calendar) {

		Session session = sessionFactory.getCurrentSession();
		session.delete(calendar);

		return true;
	}

	@Override
	public Event addEvent(Event event) {
		sessionFactory.getCurrentSession().persist(event);

		return event;
	}

	@Override
	public boolean removeEvent(Event event) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(event);

		return true;
	}

	@Override
	public boolean updateEvent(Event event) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(event);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Event> getEvents(int calendarId) {

		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Event e WHERE e.calendar.calendarId = " + calendarId;
		Query query = session.createQuery(hql);
		List<Event> results = query.list();
		if (results.size() > 0) {
			return results;
		} else {
			return null;
		}
	}

	@Override
	public Event getEventById(int eventId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Event e WHERE e.eventId = " + eventId;
		Query query = session.createQuery(hql);
		List<Event> results = query.list();
		if (results.size() > 0) {
			return results.get(0);
		} else {
			return null;
		}
	}

}
