package com.filemanager.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.filemanager.entities.Pacienti;
import com.filemanager.repository.interfaces.PacientiRepository;
import com.filemanager.transporters.model.PacientModel;

@Repository
public class PacientiRepositoryImpl implements PacientiRepository {

	private SessionFactory sessionFactory;

	public void save(PacientModel model) {
		Session session = sessionFactory.openSession();
		Pacienti pacient = new Pacienti();
		pacient.setNume("adrian");
		pacient.setPrenume("barna");
		session.beginTransaction();
		session.save(pacient);
		session.getTransaction().commit();

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
