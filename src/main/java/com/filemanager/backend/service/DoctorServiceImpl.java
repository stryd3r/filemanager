package com.filemanager.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filemanager.backend.dao.interfaces.DoctorDao;
import com.filemanager.backend.service.interfaces.DoctorService;
import com.filemanager.utils.transporters.entities.Doctor;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDao doctorDao;

	@Override
	public boolean insertDoctor(Doctor doctor) {
		return doctorDao.insertDoctor(doctor);
	}

	@Override
	public List<Doctor> getDoctor(boolean withCalendar, boolean withConsultations, boolean withPacients) {
		return doctorDao.getDoctor(withCalendar, withConsultations, withPacients);
	}

	@Override
	public boolean updateDoctor(Doctor doctor) {
		return doctorDao.updateDoctor(doctor);
	}

	@Override
	public boolean deleteDoctor(Doctor doctor) {
		return doctorDao.deleteDoctor(doctor);
	}

}
