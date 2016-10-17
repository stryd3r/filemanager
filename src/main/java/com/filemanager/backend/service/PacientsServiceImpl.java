package com.filemanager.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filemanager.backend.dao.interfaces.ConsultationDao;
import com.filemanager.backend.dao.interfaces.DoctorDao;
import com.filemanager.backend.dao.interfaces.PacientDao;
import com.filemanager.backend.service.interfaces.PacientsService;
import com.filemanager.utils.transporters.dto.complex.PacientComplexDto;
import com.filemanager.utils.transporters.dto.simple.ConsultationDto;
import com.filemanager.utils.transporters.dto.simple.DoctorDto;
import com.filemanager.utils.transporters.dto.simple.PacientDetailsDto;
import com.filemanager.utils.transporters.dto.simple.PacientDto;

@Service
@Transactional(rollbackFor = Exception.class)
public class PacientsServiceImpl implements PacientsService {

	@Autowired
	private PacientDao pacientDao;

	@Autowired
	private DoctorDao doctorDao;

	@Autowired
	private ConsultationDao consultationDao;

	@Override
	public List<PacientComplexDto> getPacients(boolean withDetail, boolean withDoctor, boolean withConsultations) {
		List<PacientComplexDto> result = new ArrayList<>();
		List<PacientDto> pacients = pacientDao.getPacients();

		for (PacientDto currentPacient : pacients) {
			PacientComplexDto pacientForResult = new PacientComplexDto();
			mapPacientDtoPropertiesToComplex(currentPacient, pacientForResult);
			populateAdditionalObjects(withDetail, withDoctor, withConsultations, currentPacient, pacientForResult);

			result.add(pacientForResult);
		}
		return result;
	}

	@Override
	public int insertPacient(PacientDto pacient) {
		return pacientDao.insertPacient(pacient);
	}

	@Override
	public int insertPacientWithDetails(PacientComplexDto pacient, boolean withDetail, boolean withDoctor, boolean withConsultations) {
		int pacientId;
		if (withDoctor) {
			int doctorId = doctorDao.insertDoctor(pacient.getDoctor());
			pacient.setDoctorId(doctorId);
		}
		pacientId = pacientDao.insertPacient(pacient);
		pacient.setPacientId(pacientId);
		if (withDetail) {
			pacient.getPacientDetailsDto().setPacientId(pacient.getPacientId());
			pacientDao.insertPacientDetails(pacient.getPacientDetailsDto());
		}
		if (withConsultations) {
			for (ConsultationDto currentConsultation : pacient.getConsultations()) {
				currentConsultation.setPacientId(pacient.getPacientId());
				currentConsultation.setDoctorId(pacient.getDoctorId());
				consultationDao.insertConsultation(currentConsultation);
			}
		}
		return pacientId;
	}

	@Override
	public PacientComplexDto getPacientById(int id, boolean withDetail, boolean withDoctor, boolean withConsultations) {
		PacientComplexDto result = new PacientComplexDto();
		PacientDto pacient = pacientDao.getPacientById(id);
		mapPacientDtoPropertiesToComplex(pacient, result);
		populateAdditionalObjects(withDetail, withDoctor, withConsultations, pacient, result);
		return result;
	}

	@Override
	public boolean removePacient(int pacientId, boolean atomicDeletion) {
		if (atomicDeletion) {
			pacientDao.removePacientDetails(pacientId);
			consultationDao.removeConsultationForPacient(pacientId);
		}
		return pacientDao.removePacient(pacientId);
	}

	@Override
	public boolean updatePacient(PacientDto pacient) {
		return pacientDao.updatePacient(pacient);
	}

	@Override
	public boolean updatePacientWithDetails(PacientComplexDto pacient, boolean withDetail, boolean withDoctor, boolean withConsultations) {
		pacientDao.updatePacient(pacient);
		if (withDetail) {
			updatePacientDetails(pacient.getPacientDetailsDto());
		}
		if (withDoctor) {
			doctorDao.updateDoctor(pacient.getDoctor());
		}
		if (withConsultations) {
			for (ConsultationDto currentConsultation : pacient.getConsultations()) {
				consultationDao.updateConsultation(currentConsultation);
			}
		}

		return true;
	}

	@Override
	public boolean insertPacientDetails(PacientDetailsDto pacient) {
		return pacientDao.insertPacientDetails(pacient);
	}

	@Override
	public boolean updatePacientDetails(PacientDetailsDto pacient) {
		boolean result;
		try {
			pacientDao.getPacientDetails(pacient.getPacientId());
			result = pacientDao.updatePacientDetails(pacient);
		} catch (EmptyResultDataAccessException e) {
			// if we get where means that the user doesn't have any details and we have to insert it
			result = pacientDao.insertPacientDetails(pacient);
		}
		return result;
	}

	@Override
	public boolean removePacientDetails(int pacientId) {
		return pacientDao.removePacientDetails(pacientId);
	}

	@Override
	public PacientDetailsDto getPacientDetails(int pacientId) {
		return pacientDao.getPacientDetails(pacientId);
	}

	private void mapPacientDtoPropertiesToComplex(PacientDto currentPacient, PacientComplexDto pacientForResult) {
		pacientForResult.setPacientId(currentPacient.getPacientId());
		pacientForResult.setName(currentPacient.getName());
		pacientForResult.setSurname(currentPacient.getSurname());
		pacientForResult.setDoctorId(currentPacient.getDoctorId());
	}

	private void populateAdditionalObjects(boolean withDetail, boolean withDoctor, boolean withConsultations, PacientDto currentPacient, PacientComplexDto pacientForResult) {
		if (withDetail) {
			try {
				PacientDetailsDto details = pacientDao.getPacientDetails(currentPacient.getPacientId());
				pacientForResult.setPacientDetailsDto(details);
			} catch (EmptyResultDataAccessException e) {
				System.out.println("No details for pacientId: " + currentPacient.getPacientId());
			}
		}
		if (withDoctor) {
			DoctorDto doctor = doctorDao.getDoctorById(currentPacient.getDoctorId());
			pacientForResult.setDoctor(doctor);
		}
		if (withConsultations) {
			try {
				List<ConsultationDto> consultations = consultationDao.getConsultationsForPacient(currentPacient.getPacientId());
				pacientForResult.setConsultations(consultations);
			} catch (EmptyResultDataAccessException e) {
				System.out.println("No consultations for pacientId: " + currentPacient.getPacientId());
			}
		}
	}
}
