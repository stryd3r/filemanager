package com.filemanager.frontend.controller;

import java.util.List;

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
	private DoctorService doctorService;

	@RequestMapping(value = "/insertDoctor", method = RequestMethod.POST, produces = "application/json")
	public void insertDoctor(@RequestBody Doctor doctor) throws InvalidInputException {

		validateInput(doctor);
		doctorService.insertDoctor(doctor);
	}

	@RequestMapping(value = "/updateDoctor", method = RequestMethod.POST, produces = "application/json")
	public void updateDoctor(@RequestBody Doctor doctor) throws InvalidInputException {

		validateInput(doctor);
		doctorService.updateDoctor(doctor);
	}

	@RequestMapping(value = "/getDoctors", method = RequestMethod.POST, produces = "application/json")
	public List<Doctor> getDoctors(boolean withCalendar, boolean withConsultations, boolean withPacients) throws InvalidInputException {

		return doctorService.getDoctors(withCalendar, withConsultations, withPacients);
	}
	
	@RequestMapping(value = "/remoteDoctor", method = RequestMethod.POST, produces = "application/json")
	public boolean getDoctors(Doctor doctor) throws InvalidInputException {

		return doctorService.removeDoctor(doctor);
	}

	private void validateInput(Doctor doctor) throws InvalidInputException {
		if (StomatoUtils.isNullOrEmpty(doctor.getName()) || StomatoUtils.isNullOrEmpty(doctor.getSurname())) {
			throw new InvalidInputException("Numele sau prenumele nu este completat!");
		}
	}

}
