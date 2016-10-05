package com.filemanager.utils.transporters.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.filemanager.utils.transporters.dto.simple.EventDto;

public class EventMapper implements RowMapper<EventDto> {

	public EventDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		EventDto event = new EventDto();
		event.setEventId(rs.getInt("eventId"));
		event.setCalendarId(rs.getInt("calendarId"));
		event.setDoctorId(rs.getInt("doctorId"));
		event.setObservation(rs.getString("observation"));
		event.setStartDate(rs.getTimestamp("startDate"));
		event.setEndDate(rs.getTimestamp("endDate"));
		event.setAllDay(rs.getString("allDay"));
		event.setColor(rs.getString("color"));
		return event;
	}
}
