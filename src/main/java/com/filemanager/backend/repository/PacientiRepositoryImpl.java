package com.filemanager.backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.filemanager.backend.dao.interfaces.PacientiDao;
import com.filemanager.backend.repository.interfaces.PacientiRepository;
import com.filemanager.utils.transporters.model.PacientModel;

@Repository
public class PacientiRepositoryImpl implements PacientiRepository {

	@Autowired
	private PacientiDao pacientiDao;

	@Transactional
	public void save(PacientModel model) {
		pacientiDao.save(model);

	}

}
