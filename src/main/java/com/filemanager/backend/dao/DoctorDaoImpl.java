package com.filemanager.backend.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
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
	public Doctor insertDoctor(Doctor doctor) {

		sessionFactory.getCurrentSession().persist(doctor);
		return doctor;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Doctor> getDoctors(boolean withCalendar, boolean withConsultations, boolean withPacients) {

		Query queryResult = sessionFactory.getCurrentSession().createQuery("from Doctor");
		List<Doctor> resultEntities = queryResult.list();

		for (Doctor doctor : resultEntities) {

			if (withCalendar) {
				Hibernate.initialize(doctor.getCalendar());
			}
			if (withConsultations) {
				Hibernate.initialize(doctor.getConsultations());
			}
			if (withPacients) {
				Hibernate.initialize(doctor.getPacients());
			}
		}

		return resultEntities;
	}

	@Override
	public boolean updateDoctor(Doctor pacient) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(pacient);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean removeDoctor(Doctor doctor) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(doctor);
		return true;
	}

}
