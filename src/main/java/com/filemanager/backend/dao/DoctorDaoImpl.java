package com.filemanager.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.filemanager.backend.dao.interfaces.DoctorDao;
import com.filemanager.utils.transporters.entities.Doctor;

@Repository
public class DoctorDaoImpl implements DoctorDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean insertDoctor(Doctor doctor) {

		sessionFactory.getCurrentSession().persist(doctor);
		return true;
	}

	@Override
	public List<Doctor> getDoctor(boolean withCalendar, boolean withConsultations, boolean withPacients) {

		return null;
	}

	@Override
	public boolean updateDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return false;
	}

}
