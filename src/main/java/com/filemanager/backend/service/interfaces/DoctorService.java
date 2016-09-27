package com.filemanager.backend.service.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.entities.Doctor;

public interface DoctorService {

	boolean insertDoctor(Doctor doctor);

	List<Doctor> getDoctors(boolean withCalendar, boolean withConsultations, boolean withPacients);

	boolean updateDoctor(Doctor doctor);

	boolean removeDoctor(Doctor doctor);

}
