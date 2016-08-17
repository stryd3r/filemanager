package com.filemanager.repository.interfaces;

import org.springframework.stereotype.Repository;

import com.filemanager.transporters.model.PacientModel;

@Repository
public interface PacientiRepository {

	void save(PacientModel model);
}
