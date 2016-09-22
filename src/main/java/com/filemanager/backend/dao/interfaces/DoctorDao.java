package com.filemanager.backend.dao.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.Doctors;

public interface DoctorDao {

	boolean insertDoctor(Doctors doctor);

	List<Doctors> getDoctor();

	boolean updateDoctor(Doctors doctor);

	boolean deleteDoctor(Doctors doctor);
	
}
