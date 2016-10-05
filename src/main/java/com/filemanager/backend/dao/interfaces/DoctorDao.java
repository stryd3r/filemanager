package com.filemanager.backend.dao.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.dto.simple.DoctorDto;

public interface DoctorDao {

	int insertDoctor(DoctorDto doctor);

	List<DoctorDto> getDoctors();

	boolean updateDoctor(DoctorDto doctor);

	boolean removeDoctor(int doctorId);

	DoctorDto getDoctorById(int doctorId);

}
