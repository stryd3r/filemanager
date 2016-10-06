package com.filemanager.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filemanager.backend.service.interfaces.ConsultationService;

@RestController
public class ConsultationController {

	@Autowired
	private ConsultationService service;

	@RequestMapping(value = "/deleteConsultation", produces = "application/json")
	public boolean deleteConsultation(int consultationId) {
		boolean result = service.removeConsultation(consultationId);

		return result;
	}

	@RequestMapping(value = "/deleteConsultations", produces = "application/json")
	public boolean deleteConsultations(List<Integer> consultationsId) {
		boolean result = service.removeConsultations(consultationsId);

		return result;
	}
	/*
	 * @RequestMapping(value = "/insertConsultation", produces = "application/json") public Consultation insertConsultation(Consultation consultation) { Consultation result =
	 * service.insertConsultation(consultation);
	 * 
	 * return result; }
	 * 
	 * @RequestMapping(value = "/updateConsultation", produces = "application/json") public boolean updateConsultation(Consultation consultation) { return service.updateConsultation(consultation); }
	 * 
	 * @RequestMapping(value = "/removeConsultation", produces = "application/json") public boolean removeConsultation(Consultation consultation) { return service.removeConsultation(consultation); }
	 * 
	 * @RequestMapping(value = "/getConsultations", produces = "application/json") public List<Consultation> getConsultations(boolean withPacient, boolean withDoctor) { return
	 * service.getConsultations(withPacient, withDoctor); }
	 * 
	 * @RequestMapping(value = "/getConsultationById", produces = "application/json") public Consultation getConsultationById(int consultationId, boolean withPacient, boolean withDoctor) { return
	 * service.getConsultationById(consultationId, withPacient, withDoctor); }
	 */
}
