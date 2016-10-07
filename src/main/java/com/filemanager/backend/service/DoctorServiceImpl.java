package com.filemanager.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filemanager.backend.dao.interfaces.DoctorDao;
import com.filemanager.backend.service.interfaces.DoctorService;
import com.filemanager.utils.transporters.dto.simple.DoctorDto;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDao dao;

	@Override
	public int insertDoctor(DoctorDto doctor) {
		return dao.insertDoctor(doctor);
	}

	@Override
	public List<DoctorDto> getDoctors() {
		return dao.getDoctors();
	}

	@Override
	public boolean updateDoctor(DoctorDto doctor) {
		return dao.updateDoctor(doctor);
	}

	@Override
	public boolean removeDoctor(int doctorId) {
		return dao.removeDoctor(doctorId);
	}

	@Override
	public DoctorDto getDoctorById(int doctorId) {
		return dao.getDoctorById(doctorId);
	}

}
