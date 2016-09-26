package com.filemanager.utils.transporters.transformers;

import com.filemanager.utils.transporters.dto.EventDto;
import com.filemanager.utils.transporters.entities.Event;

public class EventsTransformer extends BeanMapper<Event, EventDto> {

	private static volatile EventsTransformer instance;

	private EventsTransformer() {
	}

	public static EventsTransformer getInstance() {
		if (instance == null) {
			synchronized (EventsTransformer.class) {
				if (instance == null) {
					instance = new EventsTransformer();
				}
			}
		}
		return instance;
	}

	@Override
	public Event dtoToEntity(EventDto dto) {
		Event entity = new Event();
		if (dto != null) {
			entity.setAllDay(dto.getAllDay());
			entity.setCalendar(CalendarTransformer.getInstance().dtoToEntity(dto.getCalendar()));
			entity.setColor(dto.getColor());
			entity.setEndDate(dto.getEndDate());
			entity.setEventId(dto.getEventId());
			entity.setObservation(dto.getObservation());
			entity.setStartDate(dto.getStartDate());
		}
		return entity;
	}

	@Override
	public EventDto entityToDto(Event entity) {
		EventDto dto = new EventDto();
		if (entity != null) {
			dto.setAllDay(entity.getAllDay());
			dto.setCalendar(CalendarTransformer.getInstance().entityToDto(entity.getCalendar()));
			dto.setColor(entity.getColor());
			dto.setEndDate(entity.getEndDate());
			dto.setEventId(entity.getEventId());
			dto.setObservation(entity.getObservation());
			dto.setStartDate(entity.getStartDate());
		}
		return dto;
	}

}