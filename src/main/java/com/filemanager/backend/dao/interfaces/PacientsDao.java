package com.filemanager.backend.dao.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.PacientsDetails;
import com.filemanager.utils.transporters.Pacients;

public interface PacientsDao {

	boolean insertPacient(Pacients input);

	List<Pacients> getPacients(boolean withDoctor, boolean withConsultatii);

	boolean updatePacient(Pacients input);

	boolean deletePacient(Pacients input);

	boolean insertDetalii(PacientsDetails input);

	boolean updateDetalii(PacientsDetails input);

	boolean removeDetalii(PacientsDetails input);
}
