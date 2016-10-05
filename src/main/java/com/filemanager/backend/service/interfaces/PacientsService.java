package com.filemanager.backend.service.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.dto.PacientDetailsDto;
import com.filemanager.utils.transporters.dto.PacientDto;

public interface PacientsService {

	public List<PacientDto> getPacients();

	public PacientDto getPacientById(int id);

	int insertPacient(PacientDto pacient);

	boolean removePacient(int pacientId);

	boolean updatePacient(PacientDto pacient);

	boolean insertPacientDetails(PacientDetailsDto pacient);

	boolean updatePacientDetails(PacientDetailsDto pacient);

	boolean removePacientDetails(int pacientId);

	PacientDetailsDto getPacientDetails(int pacientId);

}
