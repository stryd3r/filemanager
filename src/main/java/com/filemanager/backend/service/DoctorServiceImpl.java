package com.filemanager.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filemanager.backend.dao.interfaces.ConsultationDao;
import com.filemanager.backend.dao.interfaces.DoctorDao;
import com.filemanager.backend.dao.interfaces.EventDao;
import com.filemanager.backend.dao.interfaces.PacientDao;
import com.filemanager.backend.service.interfaces.DoctorService;
import com.filemanager.exceptions.ConstraintException;
import com.filemanager.utils.transporters.dto.complex.DoctorComplexDto;
import com.filemanager.utils.transporters.dto.simple.ConsultationDto;
import com.filemanager.utils.transporters.dto.simple.DoctorDto;
import com.filemanager.utils.transporters.dto.simple.EventDto;
import com.filemanager.utils.transporters.dto.simple.PacientDto;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDao doctorDao;

	@Autowired
	private PacientDao pacientDao;

	@Autowired
	private ConsultationDao consultationDao;

	@Autowired
	private EventDao eventDao;

	@Override
	public int insertDoctor(DoctorDto doctor) {
		return doctorDao.insertDoctor(doctor);
	}

	@Override
	public List<DoctorDto> getDoctors() {
		return doctorDao.getDoctors();
	}

	@Override
	public boolean updateDoctor(DoctorDto doctor) {
		return doctorDao.updateDoctor(doctor);
	}

	@Override
	public boolean removeDoctor(int doctorId) throws ConstraintException {
		checkIfconstraintsPassed(doctorId);
		return doctorDao.removeDoctor(doctorId);
	}

	private void checkIfconstraintsPassed(int doctorId) throws ConstraintException {
		List<PacientDto> pacients = pacientDao.getPacientsForDoctor(doctorId);
		if (!pacients.isEmpty()) {
			throw new ConstraintException("Doctorul nu poate fi sters deoarece are cel putin un pacient asignat!");
		}
	}

	@Override
	public DoctorDto getDoctorById(int doctorId) {
		return doctorDao.getDoctorById(doctorId);
	}

	@Override
	public DoctorComplexDto getDoctorbyIdWithDetails(int doctorId, boolean withPacients, boolean withConsultations, boolean withEvents) {
		DoctorComplexDto result = new DoctorComplexDto();
		DoctorDto doctor = doctorDao.getDoctorById(doctorId);
		mapDoctorDtoPropertiesToComplex(result, doctor);
		if (withPacients) {
			List<PacientDto> pacients = pacientDao.getPacientsForDoctor(doctorId);
			result.setPacients(pacients);
		}
		if (withConsultations) {
			List<ConsultationDto> consultations = consultationDao.getConsultationsForDoctor(doctorId);
			result.setConsultations(consultations);
		}
		if (withEvents) {
			List<EventDto> events = eventDao.getEventsForDoctor(doctorId);
			result.setEvents(events);
		}
		return result;
	}

	@Override
	public DoctorComplexDto getDoctorbyIdWithConsultationForPacient(int doctorId, int pacientId) {
		DoctorComplexDto result = new DoctorComplexDto();
		DoctorDto doctor = doctorDao.getDoctorById(doctorId);
		mapDoctorDtoPropertiesToComplex(result, doctor);
		List<ConsultationDto> consultations = consultationDao.getPacientConsultationsForDoctor(pacientId, doctorId);
		result.setConsultations(consultations);
		return result;
	}

	private void mapDoctorDtoPropertiesToComplex(DoctorComplexDto result, DoctorDto doctor) {
		result.setDoctorId(doctor.getDoctorId());
		result.setName(doctor.getName());
		result.setSurname(doctor.getSurname());
		result.setColor(doctor.getColor());
	}

}
