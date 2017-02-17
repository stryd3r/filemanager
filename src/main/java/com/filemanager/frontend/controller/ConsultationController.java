package com.filemanager.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filemanager.backend.service.interfaces.ConsultationService;
import com.filemanager.utils.transporters.dto.simple.ConsultationDto;

@RestController
@RequestMapping("/router")
public class ConsultationController {

	@Autowired
	private ConsultationService service;

	@RequestMapping(value = "/removeConsultation", produces = "application/json", method=RequestMethod.DELETE)
	public boolean removeConsultation(int consultationId) {
		boolean result = service.removeConsultation(consultationId);

		return result;
	}

	@RequestMapping(value = "/removeConsultations", produces = "application/json", method=RequestMethod.DELETE)
	public boolean removeConsultations(@RequestBody int[] ids) {
		boolean result = service.removeConsultations(ids);

		return result;
	}

	@RequestMapping(value = "/insertConsultation", method = RequestMethod.POST, produces = "application/json")
	public int insertConsultation(@RequestBody ConsultationDto consultation) {
		return service.insertConsultation(consultation);
	}

	@RequestMapping(value = "/updateConsultation", produces = "application/json")
	public boolean updateConsultation(ConsultationDto consultation) {
		return service.updateConsultation(consultation);
	}

	@RequestMapping(value = "/getConsultations", produces = "application/json")
	public List<ConsultationDto> getConsultations() {
		return service.getConsultations();
	}

	@RequestMapping(value = "/getConsultationsForPacient", produces = "application/json")
	public List<ConsultationDto> getConsultationsForPacient(int pacientId) {
		return service.getConsultationsForPacient(pacientId);
	}

	@RequestMapping(value = "/getConsultationById", produces = "application/json")
	public ConsultationDto getConsultationById(int consultationId) {
		return service.getConsultationById(consultationId);
	}
}
