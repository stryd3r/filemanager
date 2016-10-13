package com.filemanager.backend.service.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.dto.complex.PacientComplexDto;
import com.filemanager.utils.transporters.dto.simple.PacientDetailsDto;
import com.filemanager.utils.transporters.dto.simple.PacientDto;

public interface PacientsService {

	int insertPacient(PacientDto pacient);

	boolean removePacient(int pacientId, boolean atomicDeletion);

	boolean updatePacient(PacientDto pacient);

	boolean insertPacientDetails(PacientDetailsDto pacient);

	boolean updatePacientDetails(PacientDetailsDto pacient);

	boolean removePacientDetails(int pacientId);

	PacientDetailsDto getPacientDetails(int pacientId);

	List<PacientComplexDto> getPacients(boolean withDetails, boolean withDoctors, boolean withConsultations);

	PacientComplexDto getPacientById(int id, boolean withDetail, boolean withDoctor, boolean withConsultations);

	int insertPacientWithDetails(PacientComplexDto pacient, boolean withDetail, boolean withDoctor, boolean withConsultations);

	boolean updatePacientWithDetails(PacientComplexDto pacient, boolean withDetail, boolean withDoctor, boolean withConsultations);

}
