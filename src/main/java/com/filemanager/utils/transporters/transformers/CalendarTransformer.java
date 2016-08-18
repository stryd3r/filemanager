package com.filemanager.utils.transporters.transformers;

import com.filemanager.utils.BeanMapper;
import com.filemanager.utils.transporters.dto.CalendarDto;
import com.filemanager.utils.transporters.model.CalendarModel;

public class CalendarTransformer extends BeanMapper<CalendarModel, CalendarDto> {

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
	public CalendarModel dtoToModel(CalendarDto dto) {

		CalendarModel model = new CalendarModel();
		model.setId(dto.getId());
		model.setIdDoctor(dto.getIdDoctor());
		return model;
	}

	@Override
	public CalendarDto modelToDto(CalendarModel model) {

		CalendarDto dto = new CalendarDto();
		dto.setId(model.getId());
		dto.setIdDoctor(model.getIdDoctor());
		return dto;
	}

}
