package com.filemanager.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filemanager.backend.service.interfaces.PacientsService;
import com.filemanager.utils.transporters.dto.PacientDetailsDto;
import com.filemanager.utils.transporters.dto.PacientDto;

@RestController
public class PacientController {

	@Autowired
	private PacientsService pacientService;

	@RequestMapping(value = "/getPacients", produces = "application/json")
	public List<PacientDto> getPacients() {
		List<PacientDto> pacientsList = pacientService.getPacients();
		return pacientsList;
	}

	@RequestMapping(value = "/getPacientById", produces = "application/json")
	public PacientDto getPacientById(int pacientId) {
		PacientDto pacient = pacientService.getPacientById(pacientId);

		return pacient;
	}

	@RequestMapping(value = "/insertPacient", method = RequestMethod.POST, produces = "application/json")
	public int insertPacient(@RequestBody PacientDto pacient) throws Exception {

		return pacientService.insertPacient(pacient);
	}

	@RequestMapping(value = "/updatePacient", method = RequestMethod.POST, produces = "application/json")
	public boolean updatePacient(@RequestBody PacientDto pacient) {

		return pacientService.updatePacient(pacient);
	}

	@RequestMapping(value = "/removePacient", method = RequestMethod.POST, produces = "application/json")
	public boolean removePacient(@RequestBody int pacientId) {

		return pacientService.removePacient(pacientId);
	}

	@RequestMapping(value = "/insertPacientDetails", method = RequestMethod.POST, produces = "application/json")
	public boolean insertPacientDetails(@RequestBody PacientDetailsDto pacientDetails) {

		return pacientService.insertPacientDetails(pacientDetails);
	}

	@RequestMapping(value = "/updatePacientDetails", method = RequestMethod.POST, produces = "application/json")
	public boolean updatePacientDetails(@RequestBody PacientDetailsDto pacientDetails) {

		return pacientService.updatePacientDetails(pacientDetails);
	}

	@RequestMapping(value = "/removePacientDetails", produces = "application/json")
	public boolean removePacientDetails(int pacientId) {
		boolean success = pacientService.removePacientDetails(pacientId);

		return success;
	}


}
