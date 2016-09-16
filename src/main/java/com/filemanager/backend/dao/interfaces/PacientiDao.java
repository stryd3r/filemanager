package com.filemanager.backend.dao.interfaces;

import java.util.List;

import com.filemanager.backend.entities.Pacienti;
import com.filemanager.utils.transporters.model.PacientModel;

public interface PacientiDao {

	boolean save(PacientModel input);
	List<Pacienti> getPacienti();
}
