package com.filemanager.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filemanager.backend.service.interfaces.DoctorService;
import com.filemanager.exceptions.InvalidInput;
import com.filemanager.utils.StomatoUtils;
import com.filemanager.utils.transporters.entities.Doctors;

@RestController
public class DoctorsController {

	@Autowired
	private DoctorService doctoriService;

	@RequestMapping(value = "/insertDoctor", method = RequestMethod.POST, produces = "application/json")
	public void insertDoctor(@RequestBody Doctors doctor) throws InvalidInput {

		validateInput(doctor);
		doctoriService.insertDoctor(doctor);
	}

	private void validateInput(Doctors doctor) throws InvalidInput {
		if (StomatoUtils.isNullOrEmpty(doctor.getName()) || StomatoUtils.isNullOrEmpty(doctor.getSurname())) {
			throw new InvalidInput("Numele sau prenumele nu este completat!");
		}
	}

}
