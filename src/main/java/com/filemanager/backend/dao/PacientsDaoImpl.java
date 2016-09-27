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
public class PacientsDaoImpl implements PacientsDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean insertPacient(Pacient pacient) throws Exception {
		sessionFactory.getCurrentSession().persist(pacient);

		return true;
	}

	@Override
	public List<Pacient> getPacients(boolean withDoctor, boolean withConsultation, boolean withQuestionnaireAnswers) {

		Query queryResult = sessionFactory.getCurrentSession().createQuery("from Pacient");
		@SuppressWarnings("unchecked")
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
	public boolean updatePacient(Pacient input) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Pacient pacient = (Pacient) session.load(Pacient.class, new Integer(input.getPacientId()));
			pacient.setName(input.getName());
			session.update(pacient);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deletePacient(Pacient input) {
		Session session = sessionFactory.getCurrentSession();
		Pacient pacient = (Pacient) session.load(Pacient.class, new Integer(input.getPacientId()));
		session.delete(pacient);
		return true;
	}

	@Override
	public boolean insertPacientDetails(Pacient pacient) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(pacient.getPacientDetail());

		return true;
	}

	@Override
	public boolean updatePacientDetails(Pacient pacient) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update PacientsDetails set address = :address" + " where pacientId = :pacientId");
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
		Query query = session.createQuery("delete PacientsDetails where pacientId = :pacientId");
		query.setParameter("pacientId", pacient.getPacientId());
		int result = query.executeUpdate();
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

}
