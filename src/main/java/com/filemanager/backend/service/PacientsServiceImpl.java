package com.filemanager.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filemanager.backend.repository.interfaces.PacientsRepository;
import com.filemanager.backend.service.interfaces.PacientsService;
import com.filemanager.utils.transporters.dto.PacientsDto;
import com.filemanager.utils.transporters.entities.Pacients;

@Service
public class PacientsServiceImpl implements PacientsService {

	@Autowired
	private PacientsRepository repository;

	@Override
	public List<PacientsDto> getPacients(boolean withDoctor, boolean withConsultation) {
		return repository.getPacient(withDoctor, withConsultation);
	}

	@Override
	public boolean insertPacient(Pacients pacient) {
		return repository.insertPacient(pacient);
	}

	@Override
	public boolean updatePacient(Pacients pacient) {
		return repository.updatePacient(pacient);
	}

	@Override
	public boolean deletePacient(Pacients pacient) {
		return repository.deletePacient(pacient);
	}

}
