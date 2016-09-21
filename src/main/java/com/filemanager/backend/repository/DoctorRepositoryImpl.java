package com.filemanager.backend.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.filemanager.backend.dao.interfaces.DoctorDao;
import com.filemanager.backend.repository.interfaces.DoctorRepository;
import com.filemanager.utils.transporters.Doctors;

@Repository
@Transactional
public class DoctorRepositoryImpl implements DoctorRepository {

	@Autowired
	private DoctorDao doctorDao;

	@Override
	public boolean insertDoctor(Doctors doctor) {
		return doctorDao.insertDoctor(doctor);
	}

	@Override
	public List<Doctors> getDoctor() {
		return doctorDao.getDoctor();
	}

	@Override
	public boolean updateDoctor(Doctors doctor) {
		return doctorDao.updateDoctor(doctor);
	}

	@Override
	public boolean deleteDoctor(Doctors doctor) {
		return doctorDao.deleteDoctor(doctor);
	}


}
