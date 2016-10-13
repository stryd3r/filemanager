package com.filemanager.backend.service.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.dto.simple.ConsultationDto;

public interface ConsultationService {

	boolean removeConsultation(int consultationId);

	boolean removeConsultations(List<Integer> consultations);

	int insertConsultation(ConsultationDto consultation);

	boolean updateConsultation(ConsultationDto consultation);

	List<ConsultationDto> getConsultations();

	List<ConsultationDto> getConsultationsForPacient(int pacientId);

	public ConsultationDto getConsultationById(int consultationId);

}
