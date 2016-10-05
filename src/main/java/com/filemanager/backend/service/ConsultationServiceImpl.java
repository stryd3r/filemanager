package com.filemanager.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filemanager.backend.dao.interfaces.ConsultationDao;
import com.filemanager.backend.service.interfaces.ConsultationService;
import com.filemanager.utils.transporters.entities.Consultation;

@Service
@Transactional(rollbackFor = Exception.class)
public class ConsultationServiceImpl implements ConsultationService {

	@Autowired
	private ConsultationDao dao;

	@Override
	public Consultation insertConsultation(Consultation consultation) {
		return dao.insertConsultation(consultation);
	}

	@Override
	public boolean updateConsultation(Consultation consultation) {
		return dao.updateConsultation(consultation);
	}

	@Override
	public boolean removeConsultation(Consultation consultation) {
		return dao.removeConsultation(consultation);
	}

	@Override
	public List<Consultation> getConsultations(boolean withPacient, boolean withDoctor) {
		return dao.getConsultations(withPacient, withDoctor);
	}

	@Override
	public Consultation getConsultationById(int consultationId, boolean withPacient, boolean withDoctor) {
		return dao.getConsultationById(consultationId, withPacient, withDoctor);
	}

}
