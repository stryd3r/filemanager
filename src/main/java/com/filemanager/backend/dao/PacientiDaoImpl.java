package com.filemanager.backend.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.filemanager.backend.dao.interfaces.PacientiDao;
import com.filemanager.utils.transporters.Pacienti;

@Repository
@Transactional
public class PacientiDaoImpl implements PacientiDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean insert(Pacienti input) {
		Session session = sessionFactory.getCurrentSession();
		sessionFactory.getCurrentSession().persist(input);

		return true;
	}

	@Override
	public List<Pacienti> getPacienti(boolean withDoctor, boolean withConsultatii) {

		Pacienti p = new Pacienti();

		Query queryResult = sessionFactory.getCurrentSession().createQuery("from Pacienti");
		@SuppressWarnings("unchecked")
		List<Pacienti> resultEntities = queryResult.list();

		if (withDoctor) {
			Hibernate.initialize(resultEntities.get(0).getDoctori());
		}
		if (withConsultatii) {
			Hibernate.initialize(resultEntities.get(0).getConsultatii());
		}

		return resultEntities;
	}

	@Override
	public boolean update(Pacienti pacient) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(pacient);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Pacienti pacient) {
		// TODO Auto-generated method stub
		return false;
	}

}
