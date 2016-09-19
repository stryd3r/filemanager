package com.filemanager.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filemanager.backend.repository.interfaces.PacientiRepository;
import com.filemanager.backend.service.interfaces.PacientiService;
import com.filemanager.utils.transporters.Pacienti;

@Service
public class PacientiServiceImpl implements PacientiService {

	@Autowired
	private PacientiRepository repository;

	@Override
	public List<Pacienti> getPacienti(boolean withDoctor, boolean withConsultatii) {
		return repository.getPacienti(withDoctor, withConsultatii);
	}

	@Override
	public boolean insert(Pacienti pacient) {
		return repository.insert(pacient);
	}

	@Override
	public boolean update(Pacienti pacient) {
		return repository.update(pacient);
	}

	@Override
	public boolean delete(Pacienti pacient) {
		return repository.delete(pacient);
	}

}
