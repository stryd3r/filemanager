package com.filemanager.backend.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.filemanager.backend.dao.interfaces.PacientiDao;
import com.filemanager.backend.entities.Pacienti;
import com.filemanager.utils.transporters.model.PacientModel;

@Repository
public class PacientiDaoImpl implements PacientiDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean save(PacientModel input) {
		Pacienti pacient = new Pacienti();
		pacient.setNume("adrian");
		pacient.setPrenume("barna");
		pacient.getDetaliiPacient().setAdresa("Lalelelor");
		sessionFactory.getCurrentSession().save(pacient);
		return true;
	}

}
