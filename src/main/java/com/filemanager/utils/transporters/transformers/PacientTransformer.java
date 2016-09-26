package com.filemanager.utils.transporters.transformers;

import com.filemanager.utils.transporters.dto.PacientsDto;
import com.filemanager.utils.transporters.entities.Pacients;

public class PacientTransformer extends BeanMapper<Pacients, PacientsDto> {

	private static volatile PacientTransformer instance;

	private PacientTransformer() {
	}

	public static PacientTransformer getInstance() {
		if (instance == null) {
			synchronized (PacientTransformer.class) {
				if (instance == null) {
					instance = new PacientTransformer();
				}
			}
		}
		return instance;
	}

	@Override
	public Pacients dtoToEntity(PacientsDto dto) {

		Pacients entity = new Pacients();
		if (dto != null) {
			entity.setPacientId(dto.getPacientId());
			entity.setName(dto.getName());
			entity.setSurname(dto.getSurname());
			entity.setConsultations(ConsultationsTransformer.getInstance().dtoToEntityAsList(dto.getConsultations()));
			entity.setDoctor(DoctorTransformer.getInstance().dtoToEntity(dto.getDoctor()));
			entity.setPacientDetail(PacientDetailTransformer.getInstance().dtoToEntity(dto.getPacientDetail()));
			entity.setQuestionnaireAnswer(QuestionnaireAnswerTransformer.getInstance().dtoToEntity(dto.getQuestionnaireAnswer()));
		}
		return entity;
	}

	@Override
	public PacientsDto entityToDto(Pacients entity) {

		PacientsDto dto = new PacientsDto();
		if (entity != null) {
			dto.setPacientId(entity.getPacientId());
			dto.setName(entity.getName());
			dto.setSurname(entity.getSurname());
			dto.setConsultations(ConsultationsTransformer.getInstance().entityToDtoAsList(entity.getConsultations()));
			dto.setDoctor(DoctorTransformer.getInstance().entityToDto(entity.getDoctor()));
			dto.setPacientDetail(PacientDetailTransformer.getInstance().entityToDto(entity.getPacientDetail()));
			dto.setQuestionnaireAnswer(QuestionnaireAnswerTransformer.getInstance().entityToDto(entity.getQuestionnaireAnswer()));
		}
		return dto;
	}
}