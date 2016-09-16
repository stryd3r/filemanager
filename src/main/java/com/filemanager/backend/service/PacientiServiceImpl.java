package com.filemanager.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filemanager.backend.entities.Pacienti;
import com.filemanager.backend.repository.interfaces.PacientiRepository;
import com.filemanager.backend.service.interfaces.PacientiService;

@Service
public class PacientiServiceImpl implements PacientiService {

	@Autowired
	private PacientiRepository repository;

	@Override
	public List<Pacienti> getPacienti() {
		return repository.getPacienti();
	}

}
