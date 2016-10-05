package com.filemanager.backend.dao.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.dto.simple.PacientDetailsDto;
import com.filemanager.utils.transporters.dto.simple.PacientDto;

public interface PacientDao {

	public List<PacientDto> getPacients();

	public PacientDto getPacientById(int id);

	int insertPacient(PacientDto pacient);

	boolean removePacient(int pacientId);

	boolean updatePacient(PacientDto pacient);

	boolean insertPacientDetails(PacientDetailsDto pacientDetails);

	boolean updatePacientDetails(PacientDetailsDto pacientDetails);

	boolean removePacientDetails(int pacientId);

	PacientDetailsDto getPacientDetails(int pacientId);

}
