package com.filemanager.backend.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.filemanager.backend.dao.interfaces.PacientiDao;
import com.filemanager.backend.repository.interfaces.PacientiRepository;
import com.filemanager.utils.transporters.Pacienti;

@Repository
@Transactional
public class PacientiRepositoryImpl implements PacientiRepository {

	@Autowired
	private PacientiDao pacientiDao;

	@Override
	public List<Pacienti> getPacienti(boolean withDoctor, boolean withConsultatii) {
		return pacientiDao.getPacienti(withDoctor, withConsultatii);
	}

	@Override
	public boolean insert(Pacienti pacient) {
		try {
			return pacientiDao.insert(pacient);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean update(Pacienti pacient) {
		return pacientiDao.update(pacient);
	}

	@Override
	public boolean delete(Pacienti pacient) {
		return pacientiDao.delete(pacient);
	}

}
