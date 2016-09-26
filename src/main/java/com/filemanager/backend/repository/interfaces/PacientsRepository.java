package com.filemanager.backend.repository.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.dto.PacientsDto;
import com.filemanager.utils.transporters.entities.Pacients;

public interface PacientsRepository {

	boolean insertPacient(Pacients pacient);

	List<PacientsDto> getPacient(boolean withDoctor, boolean withConsultation);

	boolean updatePacient(Pacients pacient);

	boolean deletePacient(Pacients pacient);
}
