package com.filemanager.backend.service.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.Doctors;

public interface DoctorService {

	boolean insertDoctor(Doctors doctor);

	List<Doctors> getDoctor();

	boolean updateDoctor(Doctors doctor);

	boolean deleteDoctor(Doctors doctor);
}
