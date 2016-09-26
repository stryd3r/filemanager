package com.filemanager.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.filemanager.backend.dao.interfaces.DoctorDao;
import com.filemanager.utils.transporters.entities.Doctors;

@Repository
@Transactional
public class DoctorDaoImpl implements DoctorDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean insertDoctor(Doctors doctor) {
		
		sessionFactory.getCurrentSession().persist(doctor);
		return true;
	}

	@Override
	public List<Doctors> getDoctor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateDoctor(Doctors doctor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDoctor(Doctors doctor) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
