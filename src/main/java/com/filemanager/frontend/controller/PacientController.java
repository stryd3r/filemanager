package com.filemanager.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filemanager.backend.service.interfaces.PacientsService;
import com.filemanager.utils.transporters.entities.Pacient;

@RestController
public class PacientController {

	@Autowired
	private PacientsService pacientService;

	@RequestMapping(value = "/getPacients", produces = "application/json")
	public List<Pacient> getPacients(boolean withDoctors, boolean withConsultations, boolean withQuestionnaireAnswers) {
		List<Pacient> result = pacientService.getPacients(withDoctors, withConsultations, withQuestionnaireAnswers);

		return result;
	}

	@RequestMapping(value = "/getPacientById", produces = "application/json")
	public Pacient getPacientById(int pacientId, boolean withDoctor, boolean withConsultation, boolean withQuestionnaireAnswers) {
		Pacient pacient = pacientService.getPacientById(pacientId, withDoctor, withConsultation, withQuestionnaireAnswers);

		return pacient;
	}

	@RequestMapping(value = "/insertPacient", method = RequestMethod.POST, produces = "application/json")
	public Pacient insertPacient(@RequestBody Pacient pacient) throws Exception {

		return pacientService.insertPacient(pacient);
	}

	@RequestMapping(value = "/updatePacient", method = RequestMethod.POST, produces = "application/json")
	public boolean updatePacient(@RequestBody Pacient pacient) {

		return pacientService.updatePacient(pacient);
	}

	@RequestMapping(value = "/removePacient", method = RequestMethod.POST, produces = "application/json")
	public boolean removePacient(@RequestBody Pacient pacient) {

		return pacientService.removePacient(pacient);
	}

	@RequestMapping(value = "/insertPacientDetails", method = RequestMethod.POST, produces = "application/json")
	public Pacient insertPacientDetails(@RequestBody Pacient pacient) {

		return pacientService.insertPacientDetails(pacient);
	}

	@RequestMapping(value = "/updatePacientDetails", method = RequestMethod.POST, produces = "application/json")
	public boolean updatePacientDetails(@RequestBody Pacient pacient) {

		return pacientService.updatePacientDetails(pacient);
	}

	@RequestMapping(value = "/removePacientDetails", method = RequestMethod.POST, produces = "application/json")
	public boolean removePacientDetails(@RequestBody Pacient pacient) {

		return pacientService.removePacientDetails(pacient);
	}

}
