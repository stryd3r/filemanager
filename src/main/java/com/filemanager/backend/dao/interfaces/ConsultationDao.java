package com.filemanager.backend.dao.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.dto.simple.ConsultationDto;

public interface ConsultationDao {

	int insertConsultation(ConsultationDto consultation);

	boolean updateConsultation(ConsultationDto consultation);

	List<ConsultationDto> getConsultations();

	List<ConsultationDto> getConsultationsForPacient(int pacientId);

	List<ConsultationDto> getConsultationsForDoctor(int doctorId);

	List<ConsultationDto> getPacientConsultationsForDoctor(int pacientId, int doctorId);

	public ConsultationDto getConsultationById(int consultationId);

	boolean removeConsultation(int consultationId);

	boolean removeConsultationForPacient(int pacientId);

}
