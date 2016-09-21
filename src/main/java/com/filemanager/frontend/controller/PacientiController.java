package com.filemanager.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filemanager.backend.service.interfaces.PacientiService;
import com.filemanager.utils.transporters.Pacienti;

@RestController
public class PacientiController {

	@Autowired
	private PacientiService pacientiService;

	@RequestMapping(value = "/getPacienti", produces = "application/json")
	public List<Pacienti> getPacienti(boolean withDoctor, boolean withConsultatii) {
		List<Pacienti> result = pacientiService.getPacienti(withDoctor, withConsultatii);
		System.out.println("ok");

		return result;
	}

	@RequestMapping(value = "/insertPacient", method = RequestMethod.POST, produces = "application/json")
	public void insertPacienti(@RequestBody Pacienti pacient) {

		pacientiService.insert(pacient);
	}

}
