package com.filemanager.backend.repository.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.Pacients;

public interface PacientsRepository {

	boolean insertPacient(Pacients pacient);

	List<Pacients> getPacient(boolean withDoctor, boolean withConsultation);

	boolean updatePacient(Pacients pacient);

	boolean deletePacient(Pacients pacient);
}
