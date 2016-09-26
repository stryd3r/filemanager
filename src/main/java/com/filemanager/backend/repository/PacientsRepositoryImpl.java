package com.filemanager.backend.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.filemanager.backend.dao.interfaces.PacientsDao;
import com.filemanager.backend.repository.interfaces.PacientsRepository;
import com.filemanager.utils.transporters.dto.PacientsDto;
import com.filemanager.utils.transporters.entities.Pacients;

@Repository
@Transactional
public class PacientsRepositoryImpl implements PacientsRepository {

	@Autowired
	private PacientsDao pacientiDao;

	@Override
	public List<PacientsDto> getPacient(boolean withDoctor, boolean withConsultation) {
		return pacientiDao.getPacients(withDoctor, withConsultation);
	}

	@Override
	public boolean insertPacient(Pacients pacient) {
		try {
			return pacientiDao.insertPacient(pacient);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean updatePacient(Pacients pacient) {
		return pacientiDao.updatePacient(pacient);
	}

	@Override
	public boolean deletePacient(Pacients pacient) {
		return pacientiDao.deletePacient(pacient);
	}

}
