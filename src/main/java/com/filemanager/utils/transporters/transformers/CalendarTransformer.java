package com.filemanager.utils.transporters.transformers;

import com.filemanager.utils.transporters.dto.CalendarDto;
import com.filemanager.utils.transporters.entities.Calendar;

public class CalendarTransformer extends BeanMapper<Calendar, CalendarDto> {

	private static volatile CalendarTransformer instance;

	private CalendarTransformer() {
	}

	public static CalendarTransformer getInstance() {
		if (instance == null) {
			synchronized (CalendarTransformer.class) {
				if (instance == null) {
					instance = new CalendarTransformer();
				}
			}
		}
		return instance;
	}

	@Override
	public Calendar dtoToEntity(CalendarDto dto) {

		Calendar entity = new Calendar();
		if (dto != null) {
			entity.setCalendarId(dto.getCalendarId());
			entity.setDoctor(DoctorTransformer.getInstance().dtoToEntity(dto.getDoctor()));
			entity.setEvents(EventsTransformer.getInstance().dtoToEntityAsList(dto.getEvents()));

		}
		return entity;
	}

	@Override
	public CalendarDto entityToDto(Calendar entity) {
		CalendarDto dto = new CalendarDto();
		if (entity != null) {
			dto.setCalendarId(entity.getCalendarId());
			dto.setDoctor(DoctorTransformer.getInstance().entityToDto(entity.getDoctor()));
			dto.setEvents(EventsTransformer.getInstance().entityToDtoAsList(entity.getEvents()));
		}
		return dto;
	}

}