package com.filemanager.backend.service.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.Pacients;

public interface PacientsService {

	boolean insertPacient(Pacients pacient);

	List<Pacients> getPacients(boolean withDoctor, boolean withConsultation);

	boolean updatePacient(Pacients pacient);

	boolean deletePacient(Pacients pacient);
}
