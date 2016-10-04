package com.filemanager.backend.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.filemanager.backend.dao.interfaces.PacientsDao;
import com.filemanager.utils.transporters.entities.Pacient;

@Repository
@SuppressWarnings("unchecked")
public class PacientsDaoImpl implements PacientsDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Pacient insertPacient(Pacient pacient) {
		sessionFactory.getCurrentSession().persist(pacient);

		return pacient;
	}

	@Override
	public List<Pacient> getPacients(boolean withDoctor, boolean withConsultation, boolean withQuestionnaireAnswers) {

		Session session = sessionFactory.getCurrentSession();
		Query queryResult = session.createQuery("from Pacient");
		List<Pacient> resultEntities = queryResult.list();

		for (Pacient pacient : resultEntities) {

			if (withDoctor) {
				Hibernate.initialize(pacient.getDoctor());
			}
			if (withConsultation) {
				Hibernate.initialize(pacient.getConsultations());
			}
			if (withQuestionnaireAnswers) {
				Hibernate.initialize(pacient.getQuestionnaireAnswer());
			}
		}

		return resultEntities;
	}

	@Override
	public Pacient getPacientById(int id, boolean withDoctor, boolean withConsultation, boolean withQuestionnaireAnswers) {
		Session session = sessionFactory.getCurrentSession();
		Pacient pacient = new Pacient();
		String hql = "FROM Pacient p WHERE p.pacientId = " + id;
		Query query = session.createQuery(hql);
		List<Pacient> results = query.list();
		if (results.size() > 0) {
			pacient = results.get(0);
			if (withDoctor) {
				Hibernate.initialize(pacient.getDoctor());
			}
			if (withConsultation) {
				Hibernate.initialize(pacient.getConsultations());
			}
			if (withQuestionnaireAnswers) {
				Hibernate.initialize(pacient.getQuestionnaireAnswer());
			}
			return pacient;
		} else {
			return null;
		}
	}

	@Override
	public boolean updatePacient(Pacient pacient) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(pacient);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean removePacient(Pacient pacient) {
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("delete from Consultation " + " where pacientId = :pacientId");
		query.setParameter("pacientId", pacient.getPacientId());
		query.executeUpdate();
		session.delete(pacient);
		return true;
	}

	@Override
	public Pacient insertPacientDetails(Pacient pacient) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(pacient.getPacientDetail());

		return pacient;
	}

	@Override
	public boolean updatePacientDetails(Pacient pacient) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update PacientDetail set address = :address" + " where pacientId = :pacientId");
		query.setParameter("address", pacient.getPacientDetail().getAddress());
		query.setParameter("pacientId", pacient.getPacientId());
		int result = query.executeUpdate();
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean removePacientDetails(Pacient pacient) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete PacientDetail where pacientId = :pacientId");
		query.setParameter("pacientId", pacient.getPacientId());
		int result = query.executeUpdate();
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean changeDoctor(int pacientId, int doctorId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Pacient set doctorId = :doctorId" + " where pacientId = :pacientId");
		query.setParameter("doctorId", doctorId);
		query.setParameter("pacientId", pacientId);
		int result = query.executeUpdate();
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

}
