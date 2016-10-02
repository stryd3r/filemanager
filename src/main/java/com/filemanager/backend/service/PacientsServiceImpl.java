package com.filemanager.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filemanager.backend.dao.interfaces.PacientsDao;
import com.filemanager.backend.service.interfaces.PacientsService;
import com.filemanager.utils.transporters.entities.Pacient;

@Service
@Transactional(rollbackFor = Exception.class)
public class PacientsServiceImpl implements PacientsService {

	@Autowired
	private PacientsDao dao;

	@Override
	public List<Pacient> getPacients(boolean withDoctor, boolean withConsultation, boolean withQuestionnaireAnswers) {
		return dao.getPacients(withDoctor, withConsultation, withQuestionnaireAnswers);
	}

	@Override
	public Pacient insertPacient(Pacient pacient) {
		dao.insertPacient(pacient);
		return pacient;
	}

	@Override
	public boolean updatePacient(Pacient pacient) {
		return dao.updatePacient(pacient);
	}

	@Override
	public boolean deletePacient(Pacient pacient) {
		return dao.deletePacient(pacient);
	}

	@Override
	public Pacient insertPacientDetails(Pacient pacient) {
		return dao.insertPacientDetails(pacient);
	}

	@Override
	public boolean updatePacientDetails(Pacient pacient) {
		return dao.updatePacientDetails(pacient);
	}

	@Override
	public boolean removePacientDetails(Pacient pacient) {
		return dao.removePacientDetails(pacient);
	}

	@Override
	public Pacient getPacientById(int id, boolean withDoctor, boolean withConsultation, boolean withQuestionnaireAnswers) {
		return dao.getPacientById(id, withDoctor, withConsultation, withQuestionnaireAnswers);
	}

	@Override
	public boolean changeDoctor(int pacientId, int doctorId) {
		return dao.changeDoctor(pacientId, doctorId);
	}

}
