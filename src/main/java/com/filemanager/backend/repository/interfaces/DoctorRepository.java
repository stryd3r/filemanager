package com.filemanager.backend.repository.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.entities.Doctors;

public interface DoctorRepository {

	boolean insertDoctor(Doctors doctor);

	List<Doctors> getDoctor();

	boolean updateDoctor(Doctors doctor);

	boolean deleteDoctor(Doctors doctor);
}
