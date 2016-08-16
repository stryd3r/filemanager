package com.filemanager.transporters.transformers;

import com.filemanager.transporters.dto.DetaliiPacientDto;
import com.filemanager.transporters.model.DetaliiPacientModel;
import com.filemanager.utils.BeanMapper;

public class DetaliiPacientTransformer extends BeanMapper<DetaliiPacientModel, DetaliiPacientDto> {

	private static volatile DetaliiPacientTransformer instance;

	private DetaliiPacientTransformer() {
	}

	public static DetaliiPacientTransformer getInstance() {
		if (instance == null) {
			synchronized (DetaliiPacientTransformer.class) {
				if (instance == null) {
					instance = new DetaliiPacientTransformer();
				}
			}
		}
		return instance;
	}

	@Override
	public DetaliiPacientModel dtoToModel(DetaliiPacientDto dto) {

		DetaliiPacientModel model = new DetaliiPacientModel();
		model.setIdPacient(dto.getIdPacient());
		model.setAdresa(dto.getAdresa());

		return model;
	}

	@Override
	public DetaliiPacientDto modelToDto(DetaliiPacientModel model) {

		DetaliiPacientDto dto = new DetaliiPacientDto();
		dto.setIdPacient(model.getIdPacient());
		dto.setAdresa(model.getAdresa());

		return dto;
	}

}
