package com.filemanager.backend.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.filemanager.backend.dao.interfaces.EventDao;
import com.filemanager.utils.transporters.dto.simple.EventDto;
import com.filemanager.utils.transporters.mappers.EventMapper;

@Repository
public class EventDaoImpl implements EventDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	final private static String EVENT_TABLE_NAME = "event";
	final private static String EVENT_ID = "eventId";
	final private static String DOCTOR_ID = "doctorId";
	final private static String OBSERVATION = "observation";
	final private static String START_DATE = "startDate";
	final private static String END_DATE = "endDate";
	final private static String ALL_DAY = "allDay";
	final private static String COLOR = "color";

	final private static String WHERE_NOT_DELETED = " WHERE deleted IS NULL";
	final private static String AND_NOT_DELETED = " AND deleted IS NULL";
	final private static String DELETE = " SET deleted = 1";

	@Override
	public int insertEvent(EventDto event) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(this.jdbcTemplate).withTableName(EVENT_TABLE_NAME).usingGeneratedKeyColumns(EVENT_ID);

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put(DOCTOR_ID, event.getDoctorId());
		parameters.put(OBSERVATION, event.getObservation());
		parameters.put(START_DATE, event.getStartDate());
		parameters.put(END_DATE, event.getEndDate());
		parameters.put(ALL_DAY, event.getAllDay());
		parameters.put(COLOR, event.getColor());
		// execute insert
		Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
		// convert Number to Int using ((Number) key).intValue()
		return ((Number) key).intValue();
	}

	@Override
	public boolean updateEvent(EventDto event) {
		String sql = "UPDATE " + EVENT_TABLE_NAME + " SET " + DOCTOR_ID + "=?, " + OBSERVATION + "=?, " + START_DATE + "=?, " + END_DATE + "=?, " + ALL_DAY + "=?, " + COLOR + "=? " + " WHERE "
				+ EVENT_ID + "=?" + AND_NOT_DELETED;

		Object[] args = new Object[] { event.getDoctorId(), event.getObservation(), event.getStartDate(), event.getEndDate(), event.getAllDay(), event.getColor(), event.getEventId() };
		int success = jdbcTemplate.update(sql, args);

		boolean result = (success >= 1) ? true : false;
		return result;
	}

	@Override
	public List<EventDto> getEvents() {
		String sql = "SELECT * FROM " + EVENT_TABLE_NAME + WHERE_NOT_DELETED;
		List<EventDto> events = jdbcTemplate.query(sql, new EventMapper());

		return events;
	}

	@Override
	public EventDto getEventById(int eventId) {
		String sql = "SELECT * FROM " + EVENT_TABLE_NAME + " WHERE " + EVENT_ID + "=?" + AND_NOT_DELETED;
		Object[] args = new Object[] { eventId };
		EventDto event = jdbcTemplate.queryForObject(sql, args, new EventMapper());

		return event;
	}

	@Override
	public boolean removeEvent(int eventId) {
		String sql = "UPDATE " + EVENT_TABLE_NAME + DELETE + " WHERE " + EVENT_ID + " =?";

		Object[] args = new Object[] { eventId };
		int success = jdbcTemplate.update(sql, args);

		boolean result = (success > 0) ? true : false;
		return result;
	}

	@Override
	public List<EventDto> getEventsForDoctor(int doctorId) {
		String sql = "SELECT * FROM " + EVENT_TABLE_NAME + " WHERE " + DOCTOR_ID + "=?" + AND_NOT_DELETED;
		Object[] args = new Object[] { doctorId };
		List<EventDto> event = jdbcTemplate.query(sql, args, new EventMapper());

		return event;
	}

}
