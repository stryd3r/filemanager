package com.filemanager.utils.transporters.transformers;

import com.filemanager.utils.BeanMapper;
import com.filemanager.utils.transporters.dto.PacientDto;
import com.filemanager.utils.transporters.model.PacientModel;

public class PacientTransformer extends BeanMapper<PacientModel, PacientDto> {

	private static volatile PacientTransformer instance;

	private PacientTransformer() {
	}

	public static PacientTransformer getInstance() {
		if (instance == null) {
			synchronized (PacientTransformer.class) {
				if (instance == null) {
					instance = new PacientTransformer();
				}
			}
		}
		return instance;
	}

	@Override
	public PacientModel dtoToModel(PacientDto dto) {

		PacientModel model = new PacientModel();
		model.setId(dto.getId());
		model.setNume(dto.getNume());
		model.setPrenume(dto.getPrenume());

		return model;
	}

	@Override
	public PacientDto modelToDto(PacientModel model) {

		PacientDto dto = new PacientDto();
		dto.setId(model.getId());
		dto.setNume(model.getNume());
		dto.setPrenume(model.getPrenume());

		return dto;
	}
}
