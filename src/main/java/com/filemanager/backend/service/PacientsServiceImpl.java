package com.filemanager.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filemanager.backend.dao.interfaces.PacientsDao;
import com.filemanager.backend.service.interfaces.PacientsService;
import com.filemanager.utils.transporters.dto.PacientDetailsDto;
import com.filemanager.utils.transporters.dto.PacientDto;

@Service
@Transactional(rollbackFor = Exception.class)
public class PacientsServiceImpl implements PacientsService {

	@Autowired
	private PacientsDao dao;

	@Override
	public List<PacientDto> getPacients() {
		return dao.getPacients();
	}

	@Override
	public int insertPacient(PacientDto pacient) {
		return dao.insertPacient(pacient);
	}

	@Override
	public PacientDto getPacientById(int id) {
		return dao.getPacientById(id);
	}

	@Override
	public boolean removePacient(int pacientId) {
		return dao.removePacient(pacientId);
	}

	@Override
	public boolean updatePacient(PacientDto pacient) {
		return dao.updatePacient(pacient);
	}

	@Override
	public boolean insertPacientDetails(PacientDetailsDto pacient) {
		return dao.insertPacientDetails(pacient);
	}

	@Override
	public boolean updatePacientDetails(PacientDetailsDto pacient) {
		return dao.updatePacientDetails(pacient);
	}

	@Override
	public boolean removePacientDetails(int pacientId) {
		return dao.removePacientDetails(pacientId);
	}

	@Override
	public PacientDetailsDto getPacientDetails(int pacientId) {
		return dao.getPacientDetails(pacientId);
	}

}
