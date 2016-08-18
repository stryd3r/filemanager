package com.filemanager.utils.transporters.transformers;

import com.filemanager.utils.BeanMapper;
import com.filemanager.utils.transporters.dto.EventDto;
import com.filemanager.utils.transporters.model.EventModel;

public class EventTransformer extends BeanMapper<EventModel, EventDto> {

	private static volatile EventTransformer instance;

	private EventTransformer() {
	}

	public static EventTransformer getInstance() {
		if (instance == null) {
			synchronized (EventTransformer.class) {
				if (instance == null) {
					instance = new EventTransformer();
				}
			}
		}
		return instance;
	}

	@Override
	public EventModel dtoToModel(EventDto dto) {

		EventModel model = new EventModel();
		model.setId(dto.getId());
		model.setAllDay(dto.isAllDay());
		model.setEndDate(dto.getEndDate());
		model.setId(dto.getId());
		model.setIdCalendar(dto.getIdCalendar());
		model.setObservatie(dto.getObservatie());
		model.setStartDate(dto.getStartDate());

		return model;
	}

	@Override
	public EventDto modelToDto(EventModel model) {

		EventDto dto = new EventDto();
		dto.setId(model.getId());
		dto.setAllDay(model.isAllDay());
		dto.setEndDate(model.getEndDate());
		dto.setId(model.getId());
		dto.setIdCalendar(model.getIdCalendar());
		dto.setObservatie(model.getObservatie());
		dto.setStartDate(model.getStartDate());
		return dto;
	}

}
