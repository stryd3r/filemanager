package com.filemanager.backend.service.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.dto.PacientsDto;
import com.filemanager.utils.transporters.entities.Pacients;

public interface PacientsService {

	boolean insertPacient(Pacients pacient);

	List<PacientsDto> getPacients(boolean withDoctor, boolean withConsultation);

	boolean updatePacient(Pacients pacient);

	boolean deletePacient(Pacients pacient);
}
