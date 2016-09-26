package com.filemanager.backend.dao.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.dto.PacientsDto;
import com.filemanager.utils.transporters.entities.Pacients;
import com.filemanager.utils.transporters.entities.PacientsDetails;

public interface PacientsDao {

	boolean insertPacient(Pacients input);

	List<PacientsDto> getPacients(boolean withDoctor, boolean withConsultatii);

	boolean updatePacient(Pacients input);

	boolean deletePacient(Pacients input);

	boolean insertDetalii(PacientsDetails input);

	boolean updateDetalii(PacientsDetails input);

	boolean removeDetalii(PacientsDetails input);
}
