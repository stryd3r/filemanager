package com.filemanager.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filemanager.backend.service.interfaces.DoctorService;
import com.filemanager.exceptions.InvalidInputException;
import com.filemanager.utils.StomatoUtils;
import com.filemanager.utils.transporters.entities.Doctor;

@RestController
public class DoctorController {

	@Autowired
	private DoctorService doctoriService;

	@RequestMapping(value = "/insertDoctor", method = RequestMethod.POST, produces = "application/json")
	public void insertDoctor(@RequestBody Doctor doctor) throws InvalidInputException {

		validateInput(doctor);
		doctoriService.insertDoctor(doctor);
	}

	private void validateInput(Doctor doctor) throws InvalidInputException {
		if (StomatoUtils.isNullOrEmpty(doctor.getName()) || StomatoUtils.isNullOrEmpty(doctor.getSurname())) {
			throw new InvalidInputException("Numele sau prenumele nu este completat!");
		}
	}

}
