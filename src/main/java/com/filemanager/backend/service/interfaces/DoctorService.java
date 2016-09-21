package com.filemanager.backend.service.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.Doctori;

public interface DoctorService {

	boolean insert(Doctori doctor);

	List<Doctori> getDoctor();

	boolean update(Doctori doctor);

	boolean delete(Doctori doctor);
}
