package com.filemanager.backend.dao.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.entities.Pacient;

public interface PacientsDao {

	boolean insertPacient(Pacient input);

	List<Pacient> getPacients(boolean withDoctor, boolean withConsultation, boolean withQuestionnaireAnswers);

	Pacient getPacientById(int id, boolean withDoctor, boolean withConsultation, boolean withQuestionnaireAnswers);

	boolean updatePacient(Pacient input);

	boolean deletePacient(Pacient input);

	boolean insertPacientDetails(Pacient pacient);

	boolean updatePacientDetails(Pacient pacient);

	boolean removePacientDetails(Pacient pacient);

	boolean changeDoctor(int pacientId, int doctorId);

}
