package com.filemanager.backend.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.filemanager.backend.dao.interfaces.DoctorDao;
import com.filemanager.backend.repository.interfaces.DoctorRepository;
import com.filemanager.utils.transporters.Doctori;

@Repository
@Transactional
public class DoctorRepositoryImpl implements DoctorRepository {

	@Autowired
	private DoctorDao doctorDao;

	@Override
	public boolean insert(Doctori doctor) {
		return doctorDao.insert(doctor);
	}

	@Override
	public List<Doctori> getDoctor() {
		return doctorDao.getDoctor();
	}

	@Override
	public boolean update(Doctori doctor) {
		return doctorDao.update(doctor);
	}

	@Override
	public boolean delete(Doctori doctor) {
		return doctorDao.delete(doctor);
	}


}
