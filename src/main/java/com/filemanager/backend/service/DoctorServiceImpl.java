package com.filemanager.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filemanager.backend.repository.interfaces.DoctorRepository;
import com.filemanager.backend.service.interfaces.DoctorService;
import com.filemanager.utils.transporters.Doctors;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public boolean insertDoctor(Doctors doctor) {
		return doctorRepository.insertDoctor(doctor);
	}

	@Override
	public List<Doctors> getDoctor() {
		return doctorRepository.getDoctor();
	}

	@Override
	public boolean updateDoctor(Doctors doctor) {
		return doctorRepository.updateDoctor(doctor);
	}

	@Override
	public boolean deleteDoctor(Doctors doctor) {
		return doctorRepository.deleteDoctor(doctor);
	}


}
