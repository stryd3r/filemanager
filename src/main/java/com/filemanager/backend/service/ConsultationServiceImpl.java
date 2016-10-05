package com.filemanager.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filemanager.backend.service.interfaces.ConsultationService;

@Service
@Transactional(rollbackFor = Exception.class)
public class ConsultationServiceImpl implements ConsultationService {
/*
	@Autowired
	private ConsultationDao dao;

	@Override
	public Consultation insertConsultation(Consultation consultation) {
		return null;
	}

	@Override
	public boolean updateConsultation(Consultation consultation) {
		return false;
	}

	@Override
	public boolean removeConsultation(Consultation consultation) {
		return false;
	}

	@Override
	public List<Consultation> getConsultations(boolean withPacient, boolean withDoctor) {
		return null;
	}

	@Override
	public Consultation getConsultationById(int consultationId, boolean withPacient, boolean withDoctor) {
		return null;
	}*/

}
