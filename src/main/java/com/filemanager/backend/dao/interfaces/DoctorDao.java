package com.filemanager.backend.dao.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.entities.Doctor;

public interface DoctorDao {

	boolean insertDoctor(Doctor doctor);

	List<Doctor> getDoctor(boolean withCalendar, boolean withConsultations, boolean withPacients);

	boolean updateDoctor(Doctor doctor);

	boolean deleteDoctor(Doctor doctor);

	
}
