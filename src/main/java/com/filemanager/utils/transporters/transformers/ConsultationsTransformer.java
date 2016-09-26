package com.filemanager.utils.transporters.transformers;

import com.filemanager.utils.transporters.dto.ConsultationsDto;
import com.filemanager.utils.transporters.entities.Consultations;

public class ConsultationsTransformer extends BeanMapper<Consultations, ConsultationsDto> {

	private static volatile ConsultationsTransformer instance;

	private ConsultationsTransformer() {
	}

	public static ConsultationsTransformer getInstance() {
		if (instance == null) {
			synchronized (ConsultationsTransformer.class) {
				if (instance == null) {
					instance = new ConsultationsTransformer();
				}
			}
		}
		return instance;
	}

	@Override
	public Consultations dtoToEntity(ConsultationsDto dto) {

		Consultations entity = new Consultations();
		if (dto != null) {
			entity.setConsultationId(dto.getConsultationId());
			entity.setDiagnostic(dto.getDiagnostic());
			entity.setDoctor(DoctorTransformer.getInstance().dtoToEntity(dto.getDoctor()));
			entity.setObservations(dto.getObservations());
			entity.setPacient(PacientTransformer.getInstance().dtoToEntity(dto.getPacient()));
			entity.setPrice(dto.getPrice());
		}
		return entity;
	}

	@Override
	public ConsultationsDto entityToDto(Consultations entity) {
		ConsultationsDto dto = new ConsultationsDto();
		if (entity != null) {
			dto.setConsultationId(entity.getConsultationId());
			dto.setDiagnostic(entity.getDiagnostic());
			dto.setDoctor(DoctorTransformer.getInstance().entityToDto(entity.getDoctor()));
			dto.setObservations(entity.getObservations());
			dto.setPacient(PacientTransformer.getInstance().entityToDto(entity.getPacient()));
			dto.setPrice(entity.getPrice());
		}
		return dto;
	}

}