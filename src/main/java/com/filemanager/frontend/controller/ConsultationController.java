package com.filemanager.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filemanager.backend.service.interfaces.ConsultationService;
import com.filemanager.utils.transporters.entities.Consultation;

@RestController
public class ConsultationController {

	@Autowired
	private ConsultationService service;

	@RequestMapping(value = "/insertConsultation", produces = "application/json")
	public Consultation insertConsultation(Consultation consultation) {
		Consultation result = service.insertConsultation(consultation);

		return result;
	}

	@RequestMapping(value = "/updateConsultation", produces = "application/json")
	public boolean updateConsultation(Consultation consultation) {
		return service.updateConsultation(consultation);
	}

	@RequestMapping(value = "/removeConsultation", produces = "application/json")
	public boolean removeConsultation(Consultation consultation) {
		return service.removeConsultation(consultation);
	}

	@RequestMapping(value = "/getConsultations", produces = "application/json")
	public List<Consultation> getConsultations(boolean withPacient, boolean withDoctor) {
		return service.getConsultations(withPacient, withDoctor);
	}

	@RequestMapping(value = "/getConsultationById", produces = "application/json")
	public Consultation getConsultationById(int consultationId, boolean withPacient, boolean withDoctor) {
		return service.getConsultationById(consultationId, withPacient, withDoctor);
	}
}
