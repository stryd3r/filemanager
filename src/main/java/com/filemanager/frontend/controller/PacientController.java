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
	private PacientsService pacientiService;

	@RequestMapping(value = "/getPacients", produces = "application/json")
	public List<Pacient> getPacienti(boolean withDoctor, boolean withConsultation, boolean withQuestionnaireAnswers) {
		List<Pacient> result = pacientiService.getPacients(withDoctor, withConsultation, withQuestionnaireAnswers);
		System.out.println("ok");

		return result;
	}

	@RequestMapping(value = "/insertPacient", method = RequestMethod.POST, produces = "application/json")
	public boolean insertPacienti(@RequestBody Pacient pacient) throws Exception {

		return pacientiService.insertPacient(pacient);
	}

	@RequestMapping(value = "/updatePacient", method = RequestMethod.POST, produces = "application/json")
	public boolean updatePacient(@RequestBody Pacient pacient) {

		return pacientiService.updatePacient(pacient);
	}

	@RequestMapping(value = "/deletePacient", method = RequestMethod.POST, produces = "application/json")
	public boolean removePacient(@RequestBody Pacient pacient) {

		return pacientiService.deletePacient(pacient);
	}

	@RequestMapping(value = "/insertPacientDetails", method = RequestMethod.POST, produces = "application/json")
	public boolean insertPacientDetails(@RequestBody Pacient pacient) {

		return pacientiService.insertPacientDetails(pacient);
	}

	@RequestMapping(value = "/updatePacientDetails", method = RequestMethod.POST, produces = "application/json")
	public boolean updatePacientDetails(@RequestBody Pacient pacient) {

		return pacientiService.updatePacientDetails(pacient);
	}

	@RequestMapping(value = "/removePacientDetails", method = RequestMethod.POST, produces = "application/json")
	public boolean removePacientDetails(@RequestBody Pacient pacient) {

		return pacientiService.removePacientDetails(pacient);
	}

}
