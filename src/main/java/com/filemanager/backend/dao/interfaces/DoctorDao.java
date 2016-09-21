package com.filemanager.backend.dao.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.Doctori;

public interface DoctorDao {

	boolean insert(Doctori doctor);

	List<Doctori> getDoctor();

	boolean update(Doctori doctor);

	boolean delete(Doctori doctor);
	
}
