package com.filemanager.utils.transporters.transformers;

import com.filemanager.utils.transporters.dto.DoctorsDto;
import com.filemanager.utils.transporters.entities.Doctors;

public class DoctorTransformer extends BeanMapper<Doctors, DoctorsDto> {

	private static volatile DoctorTransformer instance;

	private DoctorTransformer() {
	}

	public static DoctorTransformer getInstance() {
		if (instance == null) {
			synchronized (DoctorTransformer.class) {
				if (instance == null) {
					instance = new DoctorTransformer();
				}
			}
		}
		return instance;
	}

	@Override
	public Doctors dtoToEntity(DoctorsDto dto) {

		Doctors entity = new Doctors();
		if (dto != null) {
			entity.setCalendar(CalendarTransformer.getInstance().dtoToEntity(dto.getCalendar()));
			entity.setConsultations(ConsultationsTransformer.getInstance().dtoToEntityAsList(dto.getConsultations()));
			entity.setDoctorId(dto.getDoctorId());
			entity.setName(dto.getName());
			if (entity.getPacients() == null) {
				entity.setPacients(PacientTransformer.getInstance().dtoToEntityAsList(dto.getPacients()));
			}
			entity.setSurname(dto.getSurname());
		}
		return entity;
	}

	@Override
	public DoctorsDto entityToDto(Doctors entity) {
		DoctorsDto dto = new DoctorsDto();
		if (entity != null) {
			dto.setCalendar(CalendarTransformer.getInstance().entityToDto(entity.getCalendar()));
			dto.setConsultations(ConsultationsTransformer.getInstance().entityToDtoAsList(entity.getConsultations()));
			dto.setDoctorId(entity.getDoctorId());
			dto.setName(entity.getName());
			if (dto.getPacients() == null) {
				dto.setPacients(PacientTransformer.getInstance().entityToDtoAsList(entity.getPacients()));
			}
			dto.setSurname(entity.getSurname());
		}
		return dto;
	}

}