package com.filemanager.backend.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.filemanager.backend.dao.interfaces.PacientiDao;
import com.filemanager.utils.transporters.DetaliiPacient;
import com.filemanager.utils.transporters.Pacienti;

@Repository
public class PacientiDaoImpl implements PacientiDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean insert(Pacienti pacient) {
		sessionFactory.getCurrentSession().persist(pacient);

		return true;
	}

	@Override
	public List<Pacienti> getPacienti(boolean withDoctor, boolean withConsultatii) {

		Query queryResult = sessionFactory.getCurrentSession().createQuery("from Pacienti");
		@SuppressWarnings("unchecked")
		List<Pacienti> resultEntities = queryResult.list();

		if (withDoctor) {
			Hibernate.initialize(resultEntities.get(0).getDoctor());
		}
		if (withConsultatii) {
			Hibernate.initialize(resultEntities.get(0).getConsultatii());
		}

		return resultEntities;
	}

	@Override
	public boolean update(Pacienti input) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Pacienti pacient = (Pacienti) session.load(Pacienti.class, new Integer(input.getIdPacient()));
			pacient.setNume(input.getNume());
			session.update(pacient);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Pacienti input) {
		Session session = sessionFactory.getCurrentSession();
		Pacienti pacient = (Pacienti) session.load(Pacienti.class, new Integer(input.getIdPacient()));
		session.delete(pacient);
		return true;
	}

	@Override
	public boolean insertDetalii(DetaliiPacient input) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDetalii(DetaliiPacient input) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeDetalii(DetaliiPacient input) {
		// TODO Auto-generated method stub
		return false;
	}

}
