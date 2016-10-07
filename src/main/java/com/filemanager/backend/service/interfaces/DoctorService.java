package com.filemanager.backend.service.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.dto.simple.DoctorDto;

public interface DoctorService {

	int insertDoctor(DoctorDto doctor);

	List<DoctorDto> getDoctors();

	boolean updateDoctor(DoctorDto doctor);

	boolean removeDoctor(int doctorId);

	DoctorDto getDoctorById(int doctorId);

}
