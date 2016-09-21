package com.filemanager.backend.repository.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.Doctori;

public interface DoctorRepository {

	boolean insert(Doctori doctor);

	List<Doctori> getDoctor();

	boolean update(Doctori doctor);

	boolean delete(Doctori doctor);
}
