package com.filemanager.backend.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.filemanager.backend.dao.interfaces.PacientiDao;
import com.filemanager.backend.repository.interfaces.PacientiRepository;
import com.filemanager.utils.transporters.Pacienti;

@Repository
public class PacientiRepositoryImpl implements PacientiRepository {

	@Autowired
	private PacientiDao pacientiDao;


	@Override
	@Transactional
	public List<Pacienti> getPacienti() {
		return pacientiDao.getPacienti();
	}

}
