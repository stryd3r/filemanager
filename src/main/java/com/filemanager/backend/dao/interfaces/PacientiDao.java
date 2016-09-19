package com.filemanager.backend.dao.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.Pacienti;

public interface PacientiDao {

	boolean save(Pacienti input);
	List<Pacienti> getPacienti();
}
