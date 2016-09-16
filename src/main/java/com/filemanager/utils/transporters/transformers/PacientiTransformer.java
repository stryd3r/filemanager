package com.filemanager.utils.transporters.transformers;

import com.filemanager.backend.entities.Pacienti;
import com.filemanager.utils.BeanMapper;
import com.filemanager.utils.transporters.dto.PacientiDto;

public class PacientiTransformer extends BeanMapper<Pacienti, PacientiDto> {

	private static volatile PacientiTransformer instance;

	private PacientiTransformer() {
	}

	public static PacientiTransformer getInstance() {
		if (instance == null) {
			synchronized (PacientiTransformer.class) {
				if (instance == null) {
					instance = new PacientiTransformer();
				}
			}
		}
		return instance;
	}

	@Override
	public Pacienti dtoToEntity(PacientiDto dto) {

		Pacienti entity = new Pacienti();
		entity.setId(dto.getId());
		entity.setNume(dto.getNume());
		entity.setPrenume(dto.getPrenume());
		entity.setDetaliiPacient(dto.getDetaliiPacient());
		entity.setDoctor(dto.getDoctor());
		entity.setConsultatii(dto.getConsultatii());

		return entity;
	}

	@Override
	public PacientiDto entityToDto(Pacienti entity) {

		PacientiDto dto = new PacientiDto();
		dto.setId(entity.getId());
		dto.setNume(entity.getNume());
		dto.setPrenume(entity.getPrenume());
		dto.setDetaliiPacient(entity.getDetaliiPacient());
		dto.setDoctor(entity.getDoctor());
		dto.setConsultatii(entity.getConsultatii());

		return dto;
	}
}
