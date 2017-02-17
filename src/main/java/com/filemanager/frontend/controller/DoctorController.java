package com.filemanager.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filemanager.backend.service.interfaces.DoctorService;
import com.filemanager.exceptions.ConstraintException;
import com.filemanager.utils.transporters.dto.complex.DoctorComplexDto;
import com.filemanager.utils.transporters.dto.simple.DoctorDto;

@RestController
@RequestMapping("/router")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@RequestMapping(value = "/insertDoctor", produces = "application/json", method = RequestMethod.POST)
	public int insertDoctor(@RequestBody DoctorDto doctor) {
		return doctorService.insertDoctor(doctor);
	}

	@RequestMapping(value = "/getDoctors", produces = "application/json")
	public List<DoctorDto> getDoctors() {
		return doctorService.getDoctors();
	}

	@RequestMapping(value = "/updateDoctor", produces = "application/json", method = RequestMethod.POST)
	public boolean updateDoctor(@RequestBody DoctorDto doctor) {
		return doctorService.updateDoctor(doctor);
	}

	@RequestMapping(value = "/removeDoctor", produces = "application/json", method = RequestMethod.DELETE)
	public boolean removeDoctor(int doctorId) throws ConstraintException {
		return doctorService.removeDoctor(doctorId);
	}

	@RequestMapping(value = "/getDoctorById", produces = "application/json")
	public DoctorDto getDoctorById(int doctorId) {
		return doctorService.getDoctorById(doctorId);
	}

	@RequestMapping(value = "/getDoctorbyIdWithDetails", produces = "application/json")
	public DoctorComplexDto getDoctorbyIdWithDetails(int doctorId, boolean withPacients, boolean withConsultations, boolean withEvents) {
		return doctorService.getDoctorbyIdWithDetails(doctorId, withPacients, withConsultations, withEvents);
	}

	@RequestMapping(value = "/getDoctorbyIdWithConsultationForPacient", produces = "application/json")
	public DoctorComplexDto getDoctorbyIdWithConsultationForPacient(int doctorId, int pacientId) {
		return doctorService.getDoctorbyIdWithConsultationForPacient(doctorId, pacientId);
	}

}
