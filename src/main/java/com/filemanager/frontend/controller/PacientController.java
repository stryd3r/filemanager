package com.filemanager.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filemanager.backend.service.interfaces.PacientsService;
import com.filemanager.utils.transporters.dto.complex.PacientComplexDto;
import com.filemanager.utils.transporters.dto.simple.PacientDetailsDto;
import com.filemanager.utils.transporters.dto.simple.PacientDto;

@RestController
@RequestMapping("/router")
public class PacientController {

	@Autowired
	private PacientsService pacientService;

	@RequestMapping(value = "/getPacients", produces = "application/json")
	public List<PacientComplexDto> getPacients(boolean withDetail, boolean withDoctor, boolean withConsultations) {
		List<PacientComplexDto> pacientsList = pacientService.getPacients(withDetail, withDoctor, withConsultations);
		return pacientsList;
	}

	@RequestMapping(value = "/getPacientById", produces = "application/json")
	public PacientComplexDto getPacientById(int pacientId, boolean withDetail, boolean withDoctor, boolean withConsultations) {
		PacientComplexDto pacient = pacientService.getPacientById(pacientId, withDetail, withDoctor, withConsultations);

		return pacient;
	}

	@RequestMapping(value = "/insertPacient", method = RequestMethod.POST, produces = "application/json")
	public int insertPacient(@RequestBody PacientDto pacient) throws Exception {

		return pacientService.insertPacient(pacient);
	}

	@RequestMapping(value = "/insertPacientWithDetails", method = RequestMethod.POST, produces = "application/json")
	public int insertPacientWithDetails(@RequestBody PacientComplexDto pacient, boolean withDetail, boolean withDoctor, boolean withConsultations) throws Exception {

		return pacientService.insertPacientWithDetails(pacient, withDetail, withDoctor, withConsultations);
	}

	@RequestMapping(value = "/updatePacient", method = RequestMethod.POST, produces = "application/json")
	public boolean updatePacient(@RequestBody PacientDto pacient) {

		return pacientService.updatePacient(pacient);
	}

	@RequestMapping(value = "/updatePacientWithDetails", method = RequestMethod.POST, produces = "application/json")
	public boolean updatePacientWithDetails(@RequestBody PacientComplexDto pacient, boolean withDetail, boolean withDoctor, boolean withConsultations) {

		return pacientService.updatePacientWithDetails(pacient, withDetail, withDoctor, withConsultations);
	}

	@RequestMapping(value = "/removePacient", produces = "application/json", method=RequestMethod.DELETE)
	public boolean removePacient(int pacientId, boolean atomicDeletion) {

		return pacientService.removePacient(pacientId,atomicDeletion);
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
