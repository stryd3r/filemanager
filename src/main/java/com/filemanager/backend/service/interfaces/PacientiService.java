package com.filemanager.backend.service.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.Pacienti;

public interface PacientiService {

	boolean insert(Pacienti pacient);

	List<Pacienti> getPacienti(boolean withDoctor, boolean withConsultatii);

	boolean update(Pacienti pacient);

	boolean delete(Pacienti pacient);
}
