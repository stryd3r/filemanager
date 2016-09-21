package com.filemanager.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filemanager.backend.repository.interfaces.DoctorRepository;
import com.filemanager.backend.service.interfaces.DoctorService;
import com.filemanager.utils.transporters.Doctori;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public boolean insert(Doctori doctor) {
		return doctorRepository.insert(doctor);
	}

	@Override
	public List<Doctori> getDoctor() {
		return doctorRepository.getDoctor();
	}

	@Override
	public boolean update(Doctori doctor) {
		return doctorRepository.update(doctor);
	}

	@Override
	public boolean delete(Doctori doctor) {
		return doctorRepository.delete(doctor);
	}


}
