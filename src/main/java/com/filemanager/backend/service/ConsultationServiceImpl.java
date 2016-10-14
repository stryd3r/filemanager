package com.filemanager.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filemanager.backend.dao.interfaces.ConsultationDao;
import com.filemanager.backend.service.interfaces.ConsultationService;
import com.filemanager.utils.transporters.dto.simple.ConsultationDto;

@Service
@Transactional(rollbackFor = Exception.class)
public class ConsultationServiceImpl implements ConsultationService {

	@Autowired
	private ConsultationDao dao;

	@Override
	public boolean removeConsultation(int consultationId) {
		return dao.removeConsultation(consultationId);
	}

	@Override
	public boolean removeConsultations(int[] ids) {

		for (int currentConsultationId : ids) {
			dao.removeConsultation(currentConsultationId);
		}

		return true;
	}

	@Override
	public int insertConsultation(ConsultationDto consultation) {
		return dao.insertConsultation(consultation);
	}

	@Override
	public boolean updateConsultation(ConsultationDto consultation) {
		return dao.updateConsultation(consultation);
	}

	@Override
	public List<ConsultationDto> getConsultations() {
		return dao.getConsultations();
	}

	@Override
	public List<ConsultationDto> getConsultationsForPacient(int pacientId) {
		return dao.getConsultationsForPacient(pacientId);
	}

	@Override
	public ConsultationDto getConsultationById(int consultationId) {
		return dao.getConsultationById(consultationId);
	}

}
