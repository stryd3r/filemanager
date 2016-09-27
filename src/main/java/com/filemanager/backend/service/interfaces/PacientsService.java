package com.filemanager.backend.service.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.entities.Pacient;

public interface PacientsService {

	boolean insertPacient(Pacient pacient) throws Exception;

	List<Pacient> getPacients(boolean withDoctor, boolean withConsultation, boolean withQuestionnaireAnswers);
	
	boolean updatePacient(Pacient pacient);

	boolean deletePacient(Pacient pacient);

	boolean insertPacientDetails(Pacient pacient);

	boolean updatePacientDetails(Pacient pacient);

	boolean removePacientDetails(Pacient pacient);

}
