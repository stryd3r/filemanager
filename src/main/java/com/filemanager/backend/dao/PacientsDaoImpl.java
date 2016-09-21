package com.filemanager.backend.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.filemanager.backend.dao.interfaces.PacientsDao;
import com.filemanager.utils.transporters.PacientsDetails;
import com.filemanager.utils.transporters.Pacients;

@Repository
public class PacientsDaoImpl implements PacientsDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean insertPacient(Pacients pacient) {
		sessionFactory.getCurrentSession().persist(pacient);

		return true;
	}

	@Override
	public List<Pacients> getPacients(boolean withDoctor, boolean withConsultation) {

		Query queryResult = sessionFactory.getCurrentSession().createQuery("from Pacients");
		@SuppressWarnings("unchecked")
		List<Pacients> resultEntities = queryResult.list();

		if (withDoctor) {
			Hibernate.initialize(resultEntities.get(0).getDoctor());
		}
		if (withConsultation) {
			Hibernate.initialize(resultEntities.get(0).getConsultations());
		}

		return resultEntities;
	}

	@Override
	public boolean updatePacient(Pacients input) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Pacients pacient = (Pacients) session.load(Pacients.class, new Integer(input.getPacientId()));
			pacient.setName(input.getName());
			session.update(pacient);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deletePacient(Pacients input) {
		Session session = sessionFactory.getCurrentSession();
		Pacients pacient = (Pacients) session.load(Pacients.class, new Integer(input.getPacientId()));
		session.delete(pacient);
		return true;
	}

	@Override
	public boolean insertDetalii(PacientsDetails input) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDetalii(PacientsDetails input) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeDetalii(PacientsDetails input) {
		// TODO Auto-generated method stub
		return false;
	}

}
