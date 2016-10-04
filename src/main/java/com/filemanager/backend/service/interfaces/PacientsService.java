package com.filemanager.backend.service.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.entities.Pacient;

public interface PacientsService {

	Pacient insertPacient(Pacient input);

	List<Pacient> getPacients(boolean withDoctor, boolean withConsultation, boolean withQuestionnaireAnswers);

	Pacient getPacientById(int id, boolean withDoctor, boolean withConsultation, boolean withQuestionnaireAnswers);

	boolean updatePacient(Pacient input);

	boolean removePacient(Pacient input);

	Pacient insertPacientDetails(Pacient pacient);

	boolean updatePacientDetails(Pacient pacient);

	boolean removePacientDetails(Pacient pacient);

	boolean changeDoctor(int pacientId, int doctorId);

}
