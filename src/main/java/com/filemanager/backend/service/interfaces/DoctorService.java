package com.filemanager.backend.service.interfaces;

import java.util.List;

import com.filemanager.exceptions.ConstraintException;
import com.filemanager.utils.transporters.dto.complex.DoctorComplexDto;
import com.filemanager.utils.transporters.dto.simple.DoctorDto;

public interface DoctorService {

	int insertDoctor(DoctorDto doctor);

	List<DoctorDto> getDoctors();

	boolean updateDoctor(DoctorDto doctor);

	boolean removeDoctor(int doctorId) throws ConstraintException;

	DoctorDto getDoctorById(int doctorId);

	DoctorComplexDto getDoctorbyIdWithDetails(int doctorId, boolean withPacients, boolean withConsultations, boolean withEvents);

	DoctorComplexDto getDoctorbyIdWithConsultationForPacient(int doctorId, int pacientId);

}
