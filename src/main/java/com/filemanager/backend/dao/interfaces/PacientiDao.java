package com.filemanager.backend.dao.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.DetaliiPacient;
import com.filemanager.utils.transporters.Pacienti;

public interface PacientiDao {

	boolean insert(Pacienti input);

	List<Pacienti> getPacienti(boolean withDoctor, boolean withConsultatii);

	boolean update(Pacienti input);

	boolean delete(Pacienti input);

	boolean insertDetalii(DetaliiPacient input);

	boolean updateDetalii(DetaliiPacient input);

	boolean removeDetalii(DetaliiPacient input);
}
