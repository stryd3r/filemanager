package com.filemanager.backend.repository.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.Pacienti;


public interface PacientiRepository {

	boolean insert(Pacienti pacient);

	List<Pacienti> getPacienti(boolean withDoctor, boolean withConsultatii);

	boolean update(Pacienti pacient);

	boolean delete(Pacienti pacient);
}
