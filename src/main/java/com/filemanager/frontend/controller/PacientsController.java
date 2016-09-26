package com.filemanager.frontend.controller;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filemanager.backend.service.interfaces.PacientsService;
import com.filemanager.utils.transporters.dto.PacientsDto;
import com.filemanager.utils.transporters.entities.Pacients;
import com.filemanager.utils.transporters.mappers.PacientsMapper;

@RestController
public class PacientsController {

	@Autowired
	private PacientsService pacientiService;

	@RequestMapping(value = "/getPacients", produces = "application/json")
	public List<PacientsDto> getPacienti(boolean withDoctor, boolean withConsultation) {
		List<PacientsDto> result = pacientiService.getPacients(withDoctor, withConsultation);
		System.out.println("ok");

		return result;
	}

	@RequestMapping(value = "/insertPacient", method = RequestMethod.POST, produces = "application/json")
	public boolean insertPacienti(@RequestBody Pacients pacient) {

		return pacientiService.insertPacient(pacient);
	}

	@RequestMapping(value = "/updatePacient", method = RequestMethod.POST, produces = "application/json")
	public boolean updatePacient(@RequestBody Pacients pacient) {

		return pacientiService.updatePacient(pacient);
	}

	@RequestMapping(value = "/deletePacient", method = RequestMethod.POST, produces = "application/json")
	public boolean removePacient(@RequestBody Pacients pacient) {

		return pacientiService.deletePacient(pacient);
	}

}
