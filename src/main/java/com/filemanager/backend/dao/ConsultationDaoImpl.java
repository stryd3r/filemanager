package com.filemanager.backend.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.filemanager.backend.dao.interfaces.ConsultationDao;
import com.filemanager.utils.transporters.entities.Consultation;

@Repository
public class ConsultationDaoImpl implements ConsultationDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Consultation insertConsultation(Consultation consultation) {
		sessionFactory.getCurrentSession().persist(consultation);
		return consultation;
	}

	@Override
	public boolean updateConsultation(Consultation consultation) {

		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(consultation);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean removeConsultation(Consultation consultation) {

		Session session = sessionFactory.getCurrentSession();
		session.delete(consultation);
		return true;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Consultation> getConsultations(boolean withPacient, boolean withDoctor) {

		Session session = sessionFactory.getCurrentSession();
		Query queryResult = session.createQuery("from Consultation");
		List<Consultation> resultEntities = queryResult.list();

		for (Consultation consultation : resultEntities) {
			if (withPacient) {
				Hibernate.initialize(consultation.getPacient());
			}
			if (withDoctor) {
				Hibernate.initialize(consultation.getDoctor());
			}
		}

		return resultEntities;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Consultation getConsultationById(int consultationId, boolean withPacient, boolean withDoctor) {
		Session session = sessionFactory.getCurrentSession();
		Consultation consultation = new Consultation();
		String hql = "FROM Consultation c WHERE c.consultationId = " + consultationId;
		Query query = session.createQuery(hql);
		List<Consultation> results = query.list();
		if (results.size() > 0) {
			consultation = results.get(0);
			if (withPacient) {
				Hibernate.initialize(consultation.getPacient());
			}
			if (withDoctor) {
				Hibernate.initialize(consultation.getDoctor());
			}
			return consultation;
		} else {
			return null;
		}
	}

}
